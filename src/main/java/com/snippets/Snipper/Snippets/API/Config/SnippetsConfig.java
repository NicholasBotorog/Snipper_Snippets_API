package com.snippets.Snipper.Snippets.API.Config;

import com.snippets.Snipper.Snippets.API.Entity.Snippet;
import com.snippets.Snipper.Snippets.API.Repository.SnippetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import java.util.List;

@Configuration
public class SnippetsConfig {


    @Bean
    CommandLineRunner commandLineRunner(SnippetRepository repository){
        TextEncryptor encryptor = Encryptors.text("password", "5c0744940b5c369b");
        return args -> {
            Snippet snippet1 = new Snippet(1, "Python", encryptor.encrypt("print('Hello, World!')"));
            Snippet snippet2 = new Snippet(2, "Python", encryptor.encrypt("def add(a, b):\n" + "return a + b"));
            Snippet snippet3 = new Snippet(3, "Python", encryptor.encrypt("print('Hello, World!')"));
            Snippet snippet4 = new Snippet(4, "JavaScript", encryptor.encrypt("console.log('Hello, World!');"));
            Snippet snippet5 = new Snippet(5, "JavaScript", encryptor.encrypt("print('Hello, World!')"));
            Snippet snippet6 = new Snippet(6, "JavaScript", encryptor.encrypt("const square = num => num * num;"));
            Snippet snippet7 = new Snippet(7, "Java", encryptor.encrypt("print('Hello, World!')"));
            Snippet snippet8 = new Snippet(8, "Java", encryptor.encrypt("print('Hello, World!')"));
            repository.saveAll(List.of(snippet1, snippet2, snippet3, snippet4, snippet5, snippet6, snippet7, snippet8));
        };
    }
}
