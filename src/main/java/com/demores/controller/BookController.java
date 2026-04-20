package com.demores.controller;

import com.demores.model.dto.request.BookRequest;
import com.demores.model.dto.response.ApiResponse;
import com.demores.model.entity.Book;
import com.demores.model.entity.BookCategory;
import com.demores.model.entity.Category;
import com.demores.service.BookCategoryService;
import com.demores.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;
    private final BookCategoryService bookCategoryService;

    public BookController(BookService bookService, BookCategoryService bookCategoryService) {
        this.bookService = bookService;
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks() {
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("Get all book success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookService.getAllBooks())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> addBook(@RequestBody BookRequest bookRequest) {
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Create book success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookService.addBook(bookRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{book-id}")
    public ResponseEntity<ApiResponse<Book>> getBookById(@PathVariable("book-id") Integer bookId) {
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Get book success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookService.getBookById(bookId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{book-id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(
            @PathVariable("book-id") Integer bookId,
            @RequestBody BookRequest bookRequest) {
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Update book success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookService.updateBook(bookId, bookRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{book-id}")
    public ResponseEntity<ApiResponse<Book>> deleteBook(@PathVariable("book-id") Integer bookId) {
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Delete book success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookService.deleteBook(bookId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // assign category to book (book_category)
    @PostMapping("/{book-id}/categories/{category-id}")
    public ResponseEntity<ApiResponse<BookCategory>> assignCategoryToBook(
            @PathVariable("book-id") Integer bookId,
            @PathVariable("category-id") Integer categoryId) {
        ApiResponse<BookCategory> response = ApiResponse.<BookCategory>builder()
                .message("Assign category to book success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookCategoryService.assignCategoryToBook(bookId, categoryId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // unassign category from book (book_category)
    @DeleteMapping("/{book-id}/categories/{category-id}")
    public ResponseEntity<ApiResponse<BookCategory>> unassignCategoryFromBook(
            @PathVariable("book-id") Integer bookId,
            @PathVariable("category-id") Integer categoryId) {
        ApiResponse<BookCategory> response = ApiResponse.<BookCategory>builder()
                .message("Unassign category from book success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookCategoryService.unassignCategoryFromBook(bookId, categoryId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // read-only join: categories of a book
    @GetMapping("/{book-id}/categories")
    public ResponseEntity<ApiResponse<List<Category>>> getCategoriesByBookId(@PathVariable("book-id") Integer bookId) {
        ApiResponse<List<Category>> response = ApiResponse.<List<Category>>builder()
                .message("Get categories by book success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(bookCategoryService.getCategoriesByBookId(bookId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
