package com.example.andrewPrj.Repository;

import com.example.andrewPrj.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //public List<Book> findByAuthor(String author);
}
