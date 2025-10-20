package com.IH.ExamenFelipeMontagne.controller;

import com.IH.ExamenFelipeMontagne.model.Author;
import com.IH.ExamenFelipeMontagne.service.IAuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController implements IAuthorController {
    @Autowired
    IAuthorService service;

    @Override
    @GetMapping ("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(service.getAllAuthors());
    }

    @Override
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAuthorById(id));
    }

    @Override
    @PostMapping ("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(service.createAuthor(author));
    }

    @Override
    @PutMapping("/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody @Valid Author author) {
        return ResponseEntity.ok(service.updateAuthor(id, author));
    }

    @Override
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

}
