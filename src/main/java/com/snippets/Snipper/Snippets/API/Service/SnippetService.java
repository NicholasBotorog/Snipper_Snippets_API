package com.snippets.Snipper.Snippets.API.Service;

import com.snippets.Snipper.Snippets.API.DTO.SnippetDTO;
import com.snippets.Snipper.Snippets.API.Entity.Snippet;
import com.snippets.Snipper.Snippets.API.Repository.SnippetRepository;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SnippetService {
    private final SnippetRepository snippetRepository;

    public SnippetService(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    public SnippetDTO addSnippet(SnippetDTO snippetNew){
        TextEncryptor encryptor = Encryptors.text("password", "5c0744940b5c369b");

        Snippet snippet = new Snippet();
        snippet.setLanguage(snippetNew.getLanguage());
        // ENCRYPTING THE CODE
        snippet.setCode(encryptor.encrypt(snippetNew.getCode()));

        Snippet newSnippet = snippetRepository.save(snippet);

        SnippetDTO snippetDTO = new SnippetDTO();
        snippetDTO.setId(newSnippet.getId());
        snippetDTO.setLanguage(newSnippet.getLanguage());
        snippetDTO.setCode(newSnippet.getCode());
        return snippetDTO;
    }

    public List<SnippetDTO> viewAll(){
        List<Snippet> snippets = snippetRepository.findAll();
        return snippets.stream().map(snippet -> mapToDTO(snippet)).collect(Collectors.toList());
    }

    public SnippetDTO viewSnippetById(Integer id){
        Snippet snippet = snippetRepository.findById(id).orElseThrow(() -> new RuntimeException("Snippet not found"));
        return mapToDTO(snippet);
    }

    public List<SnippetDTO> viewAllByLanguage(String language){
        List<Snippet> snippets = snippetRepository.findAllByLanguage(language);
//        if(snippets == null){
//            throw new RuntimeException("Snippet not found!");
//        }
        return snippets.stream().map(s -> mapToDTO(s)).collect(Collectors.toList());
    }

    private SnippetDTO mapToDTO(Snippet snippet){
        TextEncryptor encryptor = Encryptors.text("password", "5c0744940b5c369b");
        SnippetDTO snippetDTO = new SnippetDTO();
        snippetDTO.setId(snippet.getId());
        snippetDTO.setLanguage(snippet.getLanguage());
        snippetDTO.setCode(encryptor.decrypt(snippet.getCode()));
        return snippetDTO;
    }


}
