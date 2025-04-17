package com.demores.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Author {
    private Integer authorId;
    private String authorName;
    private String authorGender;
}
