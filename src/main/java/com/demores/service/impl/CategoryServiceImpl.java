package com.demores.service.impl;

import com.demores.model.dto.request.CategoryRequest;
import com.demores.model.entity.Category;
import com.demores.repository.CategoryRepository;
import com.demores.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAllCategories(int page, int size) {
        int safePage = Math.max(page, 0);
        int safeSize = Math.min(Math.max(size, 1), 100);
        int offset = safePage * safeSize;
        return categoryRepository.getAllCategoriesPaged(safeSize, offset);
    }

    @Override
    public Category addCategory(CategoryRequest categoryRequest) {
        return categoryRepository.addCategory(categoryRequest);
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.getCategoryById(categoryId);
    }

    @Override
    public Category updateCategory(Integer categoryId, CategoryRequest categoryRequest) {
        return categoryRepository.updateCategory(categoryId, categoryRequest);
    }

    @Override
    public Category deleteCategory(Integer categoryId) {
        return categoryRepository.deleteCategory(categoryId);
    }
}

