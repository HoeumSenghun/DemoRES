package com.demores.service;

import com.demores.model.dto.request.BookRequest;
import com.demores.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks(int page, int size);
    Book addBook(BookRequest bookRequest);
    Book getBookById(Integer bookId);
    Book updateBook(Integer bookId, BookRequest bookRequest);
    Book deleteBook(Integer bookId);
}
