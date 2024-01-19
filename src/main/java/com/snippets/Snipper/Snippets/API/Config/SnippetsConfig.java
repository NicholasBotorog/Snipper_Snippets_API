package com.snippets.Snipper.Snippets.API.Config;

import com.snippets.Snipper.Snippets.API.Entity.Snippet;
import com.snippets.Snipper.Snippets.API.Repository.SnippetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SnippetsConfig {


    @Bean
    CommandLineRunner commandLineRunner(SnippetRepository repository){
        return args -> {
            Snippet snippet1 = new Snippet(1, "Python", "print('Hello, World!')");
            Snippet snippet2 = new Snippet(2, "Python", "def add(a, b):\n" + "return a + b");
            Snippet snippet3 = new Snippet(3, "Python", "print('Hello, World!')");
            Snippet snippet4 = new Snippet(4, "JavaScript", "console.log('Hello, World!');");
            Snippet snippet5 = new Snippet(5, "JavaScript", "print('Hello, World!')");
            Snippet snippet6 = new Snippet(6, "JavaScript", "const square = num => num * num;");
            Snippet snippet7 = new Snippet(7, "Java", "print('Hello, World!')");
            Snippet snippet8 = new Snippet(8, "Java", "print('Hello, World!')");
            repository.saveAll(List.of(snippet1, snippet2, snippet3, snippet4, snippet5, snippet6, snippet7, snippet8));
        };
    }
}
