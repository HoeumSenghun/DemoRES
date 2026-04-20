package com.demores.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String bookName;
    private Timestamp publishDate;
    private Integer authorId;
}
