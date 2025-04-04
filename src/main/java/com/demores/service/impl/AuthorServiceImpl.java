package com.demores.service.impl;

import com.demores.model.dto.request.AuthorRequest;
import com.demores.model.entity.Author;
import com.demores.repository.AuthorRepository;
import com.demores.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }


}
