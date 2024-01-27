package com.snippets.Snipper.Snippets.API.Controller;

import com.snippets.Snipper.Snippets.API.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserDTO> fetchAll(){
        return null;
    }
}
