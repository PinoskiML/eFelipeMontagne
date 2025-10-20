package com.IH.ExamenFelipeMontagne.controller;

import com.IH.ExamenFelipeMontagne.dto.BookPatchDTO;
import com.IH.ExamenFelipeMontagne.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookController {
    ResponseEntity<List<Book>> getAllBooks();
    ResponseEntity<Book> getBookById(Long id);
    ResponseEntity<Book> createBook(Book book);
    ResponseEntity<Book> updateBook(Long id, Book book);
    ResponseEntity<Void> deleteBook(Long id);
    ResponseEntity<Book> patchBook(Long id, BookPatchDTO dto);

}
