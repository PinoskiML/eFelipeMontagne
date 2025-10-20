package com.IH.ExamenFelipeMontagne.controller;

import com.IH.ExamenFelipeMontagne.dto.BookPatchDTO;
import com.IH.ExamenFelipeMontagne.model.Book;
import com.IH.ExamenFelipeMontagne.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")


public class BookController implements IBookController {
    @Autowired
    IBookService service;


    @Override
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @Override
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBookById(id));
    }

    @Override
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody @Valid  Book book) {
        return ResponseEntity.ok(service.createBook(book));
    }

    @Override
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody @Valid Book book) {
        return ResponseEntity.ok(service.updateBook(id, book));
    }

    @Override
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/books/{id}")
    public ResponseEntity<Book> patchBook(@PathVariable Long id, @RequestBody BookPatchDTO dto) {
        return ResponseEntity.ok(service.patchBook(id, dto));
    }

}
