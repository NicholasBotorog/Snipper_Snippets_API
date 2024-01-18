package com.snippets.Snipper.Snippets.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnippetDTO {
    private Integer id;
    private String language;
    private String code;
}
