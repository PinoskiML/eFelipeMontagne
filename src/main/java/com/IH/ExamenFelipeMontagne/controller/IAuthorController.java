package com.IH.ExamenFelipeMontagne.controller;

import com.IH.ExamenFelipeMontagne.model.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAuthorController {
        ResponseEntity<List<Author>> getAllAuthors();
        ResponseEntity<Author> getAuthorById(Long id);
        ResponseEntity<Author> createAuthor(Author author);
        ResponseEntity<Author> updateAuthor(Long id, Author author);
        ResponseEntity<Void> deleteAuthor(Long id);

}
