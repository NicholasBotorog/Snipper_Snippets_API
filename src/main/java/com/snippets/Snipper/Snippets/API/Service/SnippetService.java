package com.snippets.Snipper.Snippets.API.Service;

import com.snippets.Snipper.Snippets.API.DTO.SnippetDTO;
import com.snippets.Snipper.Snippets.API.Entity.Snippet;
import com.snippets.Snipper.Snippets.API.Repository.SnippetRepository;
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
        Snippet snippet = new Snippet();
        snippet.setLanguage(snippetNew.getLanguage());
        snippet.setCode(snippet.getCode());
        Snippet newSnippet = snippetRepository.save(snippet);

        return mapToDTO(newSnippet);
    }

    public List<SnippetDTO> viewAll(){
        List<Snippet> snippets = snippetRepository.findAll();
        return snippets.stream().map(snippet -> mapToDTO(snippet)).collect(Collectors.toList());
    }

    public SnippetDTO viewSnippetById(String id){
        Snippet snippet = snippetRepository.findById(id).orElseThrow(() -> new RuntimeException("Snippet not found"));
        return mapToDTO(snippet);
    }

    private SnippetDTO mapToDTO(Snippet snippet){
        SnippetDTO snippetDTO = new SnippetDTO();
        snippetDTO.setId(snippet.getId());
        snippetDTO.setLanguage(snippet.getLanguage());
        snippetDTO.setCode(snippet.getCode());
        return snippetDTO;
    }


}
