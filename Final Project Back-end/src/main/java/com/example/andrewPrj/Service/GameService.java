package com.example.andrewPrj.Service;

import com.example.andrewPrj.Model.Book;
import com.example.andrewPrj.Model.Game;
import com.example.andrewPrj.Repository.GameRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;

    //Saves book to DB - Service (Create)
    @Transactional
    public Game create(Game game){
        return gameRepository.save(game);
    }

    //Finds all books from DB - Service (Read)
    @Transactional
    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    //Finds specific book in DB - Service (Read)
    @Transactional
    public Game findBook(Integer id){
        return gameRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Check Id - Read"));
    }

    @Transactional
    public List<Book> findByAuthor(String author){
        //return gameRepository.findByAuthor(author);
        return null;
    }

    //Updates specific book in DB - Service (Update)
    @Transactional
    public Game update(Integer id, Game game){
        Game gameObject = gameRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Check id - Update"));

        gameObject.setName(game.getName());
        gameObject.setVolume(game.getVolume());
        gameObject.setAuthor(game.getAuthor());
        gameObject.setPhysical_virtual(game.getPhysical_virtual());
        gameObject.setType(game.getType());
        gameObject.setCopies(game.getCopies());
        gameObject.setStatus(game.getStatus());

        return gameObject;
    }

    //Deletes all books in DB - Service (Delete)
    @Transactional
    public String deleteAll(){
        gameRepository.deleteAll();
        return "Deleted All";
    }

    //Deletes specific book in DB - Service (Delete)
    @Transactional
    public String deleteBook(Integer id){
        gameRepository.deleteById(id);
        return "Deleted.";
    }
}
