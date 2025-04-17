package com.demores.controller;


import com.demores.model.dto.request.AuthorRequest;
import com.demores.model.dto.response.ApiResponse;
import com.demores.model.entity.Author;
import com.demores.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    //store
    private final AuthorService authorService;
    //inject from service
    public AuthorController (AuthorService authorService) {
        this.authorService = authorService;
    }

    // get all author
    @GetMapping
    public ResponseEntity<ApiResponse<List<Author>>> getAllAuthors() {
            ApiResponse<List<Author>> response = ApiResponse.<List<Author>>builder()
                    .message("Get all author success!")
                    .status(HttpStatus.OK)
                    .success(true)
                    .payload(authorService.getAllAuthors())
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.ok(response);
    }
    // create author
    @PostMapping
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
}
