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

    private final AuthorService authorService;

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

}
