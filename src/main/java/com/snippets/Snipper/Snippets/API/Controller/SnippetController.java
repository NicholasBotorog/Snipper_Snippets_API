package com.snippets.Snipper.Snippets.API.Controller;

import com.snippets.Snipper.Snippets.API.DTO.SnippetDTO;
import com.snippets.Snipper.Snippets.API.Service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/snippets")
public class SnippetController {

    @Autowired
    private SnippetService snippetService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SnippetDTO> addSnippet(@RequestBody SnippetDTO snippetDTO){
        SnippetDTO response = snippetService.addSnippet(snippetDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SnippetDTO>> getAll(){
        List<SnippetDTO> response = snippetService.viewAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id")
    public ResponseEntity<SnippetDTO> getById(@PathVariable(value = "id") String id){
        SnippetDTO response = snippetService.viewSnippetById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
