package com.demores.service;

import com.demores.model.dto.request.AuthorRequest;
import com.demores.model.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author addAuthor(AuthorRequest authorRequest);
    Author getAuthorById(Integer authorId);
    Author updateAuthor(Integer authorId, AuthorRequest authorRequest);
}
