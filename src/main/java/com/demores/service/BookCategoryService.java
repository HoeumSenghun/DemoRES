package com.demores.service;

import com.demores.model.entity.Book;
import com.demores.model.entity.BookCategory;
import com.demores.model.entity.Category;

import java.util.List;

public interface BookCategoryService {
    BookCategory assignCategoryToBook(Integer bookId, Integer categoryId);
    BookCategory unassignCategoryFromBook(Integer bookId, Integer categoryId);
    List<Category> getCategoriesByBookId(Integer bookId);
    List<Book> getBooksByCategoryId(Integer categoryId);
}

