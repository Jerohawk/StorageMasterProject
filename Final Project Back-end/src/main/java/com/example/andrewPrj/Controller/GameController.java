package com.example.andrewPrj.Controller;


import com.example.andrewPrj.Model.Book;
import com.example.andrewPrj.Model.Game;
import com.example.andrewPrj.Service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GameController {

    @Autowired
    private final GameService gameService;

    //Saves book to DB - Controller (Create)
    @CrossOrigin
    @PostMapping("/game")
    public ResponseEntity<?> saveBook (@RequestBody Game game){
        System.out.println("Title: " + game.getName());
        System.out.println("Volume: " + game.getVolume());
        System.out.println("Author: " + game.getAuthor());
        System.out.println("Physical_Virtual: " + game.getPhysical_virtual());
        System.out.println("Type: " + game.getType());
        System.out.println("Copies: " + game.getCopies());
        System.out.println("Status: " + game.getStatus());

        return new ResponseEntity<>(gameService.create(game), HttpStatus.CREATED);
    }

    //Finds all books from DB - Controller (Read)
    @CrossOrigin
    @GetMapping("/game")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(gameService.findAll(), HttpStatus.OK);
    }

    //Finds specific book in DB by Id - Controller (Read)
    @CrossOrigin
    @GetMapping("/game/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(gameService.findBook(id), HttpStatus.OK);
    }

    //Finds specific game by Developer - Controller (Read)
//    @CrossOrigin
//    @GetMapping("/game/{author}")
//    public ResponseEntity<?> findByAuthor(@PathVariable String author){
//        return new ResponseEntity<>(gameService.findByAuthor(author), HttpStatus.OK);
//    }


    //Updates book in DB - Controller (Update)
    @CrossOrigin
    @PutMapping("/game/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Game game){
        return new ResponseEntity<>(gameService.update(id, game), HttpStatus.OK);
    }

    //Deletes all books in DB - Controller (Delete)
    @CrossOrigin
    @DeleteMapping("/game")
    public ResponseEntity<?> deleteAll(){
        return new ResponseEntity<>(gameService.deleteAll(), HttpStatus.OK);
    }

    //Deletes book in DB - Controller (Delete)
    @CrossOrigin
    @DeleteMapping("/game/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id){
        gameService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
