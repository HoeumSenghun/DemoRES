package com.demores.service.impl;

import com.demores.model.entity.Book;
import com.demores.model.entity.BookCategory;
import com.demores.model.entity.Category;
import com.demores.repository.BookCategoryRepository;
import com.demores.service.BookCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Override
    public BookCategory assignCategoryToBook(Integer bookId, Integer categoryId) {
        return bookCategoryRepository.assignCategoryToBook(bookId, categoryId);
    }

    @Override
    public BookCategory unassignCategoryFromBook(Integer bookId, Integer categoryId) {
        return bookCategoryRepository.unassignCategoryFromBook(bookId, categoryId);
    }

    @Override
    public List<Category> getCategoriesByBookId(Integer bookId) {
        return bookCategoryRepository.getCategoriesByBookId(bookId);
    }

    @Override
    public List<Book> getBooksByCategoryId(Integer categoryId) {
        return bookCategoryRepository.getBooksByCategoryId(categoryId);
    }
}

