package com.snippets.Snipper.Snippets.API.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SNIPPETS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Snippet {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String language;

    @Column
    private String code;

}
