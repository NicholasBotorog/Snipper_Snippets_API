package com.snippets.Snipper.Snippets.API.Controller;


import com.snippets.Snipper.Snippets.API.DTO.UserDTO;
import com.snippets.Snipper.Snippets.API.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InMemoryUserDetailsManager userDetailsManager;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        if(userDetailsManager.userExists(userDTO.getUsername())){
            return new ResponseEntity<>("Username and Email already in use!", HttpStatus.BAD_REQUEST);
        }

//        User user = new User();
//        user.setUsername(userDTO.getUsername());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//        userRepository.save(user);

        // Utilizing USER from Spring Security
        UserDetails user = User.builder().username(userDTO.getUsername()).password(passwordEncoder.encode(userDTO.getPassword())).roles("USER").build();

        userDetailsManager.createUser(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginUser(HttpServletRequest request){
        return new ResponseEntity<>((String) request.getAttribute("Username"),HttpStatus.OK);
    }
}
