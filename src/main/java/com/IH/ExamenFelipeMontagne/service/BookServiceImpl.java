package com.IH.ExamenFelipeMontagne.service;

import com.IH.ExamenFelipeMontagne.dto.BookPatchDTO;
import com.IH.ExamenFelipeMontagne.model.Book;
import com.IH.ExamenFelipeMontagne.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    BookRepository repository;


    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book with that Id not found"));

    }

    @Override
    public Book createBook(Book book) {
        if (book.getAuthor() == null || book.getAuthor().getId() == null) {
            throw new IllegalArgumentException("Author is required");
        }
        return repository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book with that Id not found"));
        if (book.getAuthor() == null || book.getAuthor().getId() == null) {
            throw new IllegalArgumentException("Author is required");
        }
        existingBook.setTitle(book.getTitle());
        existingBook.setPrice(book.getPrice());
        existingBook.setAuthor(book.getAuthor());
        return repository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Book patchBook(Long id, BookPatchDTO dto) { Book existingBook = repository.findById(id) .orElseThrow(() -> new IllegalArgumentException("Book with that Id not found"));
        if (dto.getTitle() != null) { existingBook.setTitle(dto.getTitle()); }
        if (dto.getPrice() != null) { existingBook.setPrice(dto.getPrice()); }
        return repository.save(existingBook); }


}
