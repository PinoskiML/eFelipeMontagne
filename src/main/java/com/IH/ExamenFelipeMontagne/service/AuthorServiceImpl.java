package com.IH.ExamenFelipeMontagne.service;


import com.IH.ExamenFelipeMontagne.model.Author;
import com.IH.ExamenFelipeMontagne.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    AuthorRepository repository;

    @Override
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Author with that Id not found"));


    }

    @Override
    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author with that Id not found"));
        existingAuthor.setName(author.getName());
        existingAuthor.setCountry(author.getCountry());
        return repository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }
}
