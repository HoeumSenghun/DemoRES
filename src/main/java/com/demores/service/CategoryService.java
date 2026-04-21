package com.demores.service;

import com.demores.model.dto.request.CategoryRequest;
import com.demores.model.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories(int page, int size);
    Category addCategory(CategoryRequest categoryRequest);
    Category getCategoryById(Integer categoryId);
    Category updateCategory(Integer categoryId, CategoryRequest categoryRequest);
    Category deleteCategory(Integer categoryId);
}

