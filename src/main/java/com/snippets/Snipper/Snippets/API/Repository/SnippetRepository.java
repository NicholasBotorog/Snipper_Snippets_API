package com.snippets.Snipper.Snippets.API.Repository;

import com.snippets.Snipper.Snippets.API.Entity.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends JpaRepository<Snippet, Integer> {
    Snippet findByLanguage(String language);
}
