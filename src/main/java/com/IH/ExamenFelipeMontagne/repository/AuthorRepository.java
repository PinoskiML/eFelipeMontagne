package com.IH.ExamenFelipeMontagne.repository;

import com.IH.ExamenFelipeMontagne.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository <Author, Long> {
}
