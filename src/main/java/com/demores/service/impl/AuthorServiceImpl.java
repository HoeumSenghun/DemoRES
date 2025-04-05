package com.demores.service.impl;

import com.demores.model.dto.request.AuthorRequest;
import com.demores.model.entity.Author;
import com.demores.repository.AuthorRepository;
import com.demores.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    //store
    private final AuthorRepository authorRepository;
    //inject from Repo
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    @Override
    public Author addAuthor(AuthorRequest authorRequest) {
        return authorRepository.addAuthor(authorRequest);
    }

    @Override
    public Author getAuthorById(Integer authorId) {
        return authorRepository.getAuthorById(authorId);
    }
}
