package com.IH.ExamenFelipeMontagne.service;
import com.IH.ExamenFelipeMontagne.dto.BookPatchDTO;
import com.IH.ExamenFelipeMontagne.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    Book patchBook(Long id, BookPatchDTO dto);


}
