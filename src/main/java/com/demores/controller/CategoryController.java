package com.demores.controller;

import com.demores.model.dto.request.CategoryRequest;
import com.demores.model.dto.response.ApiResponse;
import com.demores.model.entity.Book;
import com.demores.model.entity.Category;
import com.demores.service.BookCategoryService;
import com.demores.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final BookCategoryService bookCategoryService;

    public CategoryController(CategoryService categoryService, BookCategoryService bookCategoryService) {
        this.categoryService = categoryService;
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        ApiResponse<List<Category>> response = ApiResponse.<List<Category>>builder()
                .message("Get all category success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(categoryService.getAllCategories())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> addCategory(@RequestBody CategoryRequest categoryRequest) {
        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Create category success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(categoryService.addCategory(categoryRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<ApiResponse<Category>> getCategoryById(@PathVariable("category-id") Integer categoryId) {
        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Get category success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(categoryService.getCategoryById(categoryId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<ApiResponse<Category>> updateCategory(
            @PathVariable("category-id") Integer categoryId,
            @RequestBody CategoryRequest categoryRequest) {
        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Update category success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(categoryService.updateCategory(categoryId, categoryRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity<ApiResponse<Category>> deleteCategory(@PathVariable("category-id") Integer categoryId) {
        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Delete category success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(categoryService.deleteCategory(categoryId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // read-only join: books of a category
    @GetMapping("/{category-id}/books")
    public ResponseEntity<ApiResponse<List<Book>>> getBooksByCategoryId(@PathVariable("category-id") Integer categoryId) {
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("Get books by category success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookCategoryService.getBooksByCategoryId(categoryId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}

