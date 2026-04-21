package com.demores.controller;


import com.demores.model.dto.request.AuthorRequest;
import com.demores.model.dto.response.ApiResponse;
import com.demores.model.entity.Author;
import com.demores.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@Tag(name = "Authors", description = "Author management endpoints")
public class AuthorController {
    //store
    private final AuthorService authorService;
    //inject from service
    public AuthorController (AuthorService authorService) {
        this.authorService = authorService;
    }

    // get all author
    @GetMapping
    @Operation(summary = "Get all authors")
    public ResponseEntity<ApiResponse<List<Author>>> getAllAuthors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
            ApiResponse<List<Author>> response = ApiResponse.<List<Author>>builder()
                    .message("Get all author success!")
                    .status(HttpStatus.OK)
                    .success(true)
                    .payload(authorService.getAllAuthors(page, size))
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.ok(response);
    }
    // create author
    @PostMapping
    @Operation(summary = "Create author")
    public ResponseEntity<ApiResponse<Author>> addAuthor(@RequestBody AuthorRequest authorRequest) {
            ApiResponse<Author> response = ApiResponse.<Author>builder()
                    .message("Create author success!")
                    .status(HttpStatus.OK)
                    .success(true)
                    .payload(authorService.addAuthor(authorRequest))
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.ok(response);
    }
    // get author by id
    @GetMapping("/{author-id}")
    @Operation(summary = "Get author by id")
    public ResponseEntity<ApiResponse<Author>> getAuthorById(@PathVariable("author-id") Integer authorId) {
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Get author success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(authorService.getAuthorById(authorId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    // update author
    @PutMapping("/{author-id}")
    @Operation(summary = "Update author by id")
    public ResponseEntity<ApiResponse<Author>> updateAuthor(@PathVariable("author-id")Integer authorId,@RequestBody AuthorRequest authorRequest) {
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Update author success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(authorService.updateAuthor(authorId,authorRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    // delete author
    @DeleteMapping("/{author-id}")
    @Operation(summary = "Delete author by id")
    public ResponseEntity<ApiResponse<Author>> deleteAuthor(@PathVariable("author-id") Integer authorId) {
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Delete author success!")
                .status(HttpStatus.OK)
                .success(true)
                .payload(authorService.deleteAuthor(authorId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
