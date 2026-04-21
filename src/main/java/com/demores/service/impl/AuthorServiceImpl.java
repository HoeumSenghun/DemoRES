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
    public List<Author> getAllAuthors(int page, int size) {
        int safePage = Math.max(page, 0);
        int safeSize = Math.min(Math.max(size, 1), 100);
        int offset = safePage * safeSize;
        return authorRepository.getAllAuthorsPaged(safeSize, offset);
    }

    @Override
    public Author addAuthor(AuthorRequest authorRequest) {
        return authorRepository.addAuthor(authorRequest);
    }

    @Override
    public Author getAuthorById(Integer authorId) {
        return authorRepository.getAuthorById(authorId);
    }

    @Override
    public Author updateAuthor(Integer authorId, AuthorRequest authorRequest) {
        return authorRepository.updateAuthor(authorId,authorRequest);
    }

    @Override
    public Author deleteAuthor(Integer authorId) {
        return authorRepository.deleteAuthor(authorId);
    }
}
