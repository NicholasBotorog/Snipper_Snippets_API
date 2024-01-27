package com.snippets.Snipper.Snippets.API.Repository;

import com.snippets.Snipper.Snippets.API.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}
