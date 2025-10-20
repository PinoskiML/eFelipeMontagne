package com.IH.ExamenFelipeMontagne.repository;


import com.IH.ExamenFelipeMontagne.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
}
