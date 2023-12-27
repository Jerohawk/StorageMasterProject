package com.example.andrewPrj.Controller;

import com.example.andrewPrj.Model.Book;
import com.example.andrewPrj.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Create (C)
// Read (R)
// Update (U)
// Delete (D)
@RequiredArgsConstructor
@RestController
public class BookController {
    @Autowired
    private final BookService bookService;

    //Saves book to DB - Controller (Create)
    @CrossOrigin
    @PostMapping("/book")
    public ResponseEntity<?> saveBook (@RequestBody Book book){
        System.out.println("Title: " + book.getName());
        System.out.println("Volume: " + book.getVolume());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Physical_Virtual: " + book.getPhysical_virtual());
        System.out.println("Type: " + book.getType());
        System.out.println("Copies: " + book.getCopies());
        System.out.println("Status: " + book.getStatus());

        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }

    //Finds all books from DB - Controller (Read)
    @CrossOrigin
    @GetMapping("/book")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    //Finds specific book in DB by Id - Controller (Read)
    @CrossOrigin
    @GetMapping("/book/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(bookService.findBook(id), HttpStatus.OK);
    }

    //Finds specific book by Author - Controller (Read)
//    @CrossOrigin
//    @GetMapping("/book/{author}")
//    public ResponseEntity<?> findByAuthor(@PathVariable String author){
//        return new ResponseEntity<>(bookService.findByAuthor(author), HttpStatus.OK);
//    }


    //Updates book in DB - Controller (Update)
    @CrossOrigin
    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Book book){
        return new ResponseEntity<>(bookService.update(id, book), HttpStatus.OK);
    }

    //Deletes all books in DB - Controller (Delete)
    @CrossOrigin
    @DeleteMapping("/book")
    public ResponseEntity<?> deleteAll(){
        return new ResponseEntity<>(bookService.deleteAll(), HttpStatus.OK);
    }

    //Deletes book in DB - Controller (Delete)
    @CrossOrigin
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
