package com.demores.service.impl;

import com.demores.model.dto.request.BookRequest;
import com.demores.model.entity.Book;
import com.demores.repository.BookRepository;
import com.demores.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAllBooks(int page, int size) {
        int safePage = Math.max(page, 0);
        int safeSize = Math.min(Math.max(size, 1), 100);
        int offset = safePage * safeSize;
        return bookRepository.getAllBooksPaged(safeSize, offset);
    }

    @Override
    public Book addBook(BookRequest bookRequest) {
        return bookRepository.addBook(bookRequest);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.getBookById(bookId);
    }

    @Override
    public Book updateBook(Integer bookId, BookRequest bookRequest) {
        return bookRepository.updateBook(bookId, bookRequest);
    }

    @Override
    public Book deleteBook(Integer bookId) {
        return bookRepository.deleteBook(bookId);
    }
}
