package com.example.andrewPrj.Service;

import com.example.andrewPrj.Model.Book;
import com.example.andrewPrj.Repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

// Create (C)
// Read (R)
// Update (U)
// Delete (D)

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    //Saves book to DB - Service (Create)
    @Transactional
    public Book create(Book book){
        return bookRepository.save(book);
    }

    //Finds all books from DB - Service (Read)
    @Transactional
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //Finds specific book in DB - Service (Read)
    @Transactional
    public Book findBook(Integer id){
        return bookRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Check Id - Read"));
    }

    @Transactional
    public List<Book> findByAuthor(String author){
        //return bookRepository.findByAuthor(author);
        return null;
    }

    //Updates specific book in DB - Service (Update)
    @Transactional
    public Book update(Integer id, Book book){
        Book bookObject = bookRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Check id - Update"));

        bookObject.setName(book.getName());
        bookObject.setVolume(book.getVolume());
        bookObject.setAuthor(book.getAuthor());
        bookObject.setPhysical_virtual(book.getPhysical_virtual());
        bookObject.setType(book.getType());
        bookObject.setCopies(book.getCopies());
        bookObject.setStatus(book.getStatus());

        return bookObject;
    }

    //Deletes all books in DB - Service (Delete)
    @Transactional
    public String deleteAll(){
        bookRepository.deleteAll();
        return "Deleted All";
    }

    //Deletes specific book in DB - Service (Delete)
    @Transactional
    public String deleteBook(Integer id){
        bookRepository.deleteById(id);
        return "Deleted.";
    }

}
