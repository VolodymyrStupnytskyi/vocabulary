package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.db.UserRepository;
import com.stupnv.vocabulary.model.User;
import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class UserController {

    private final QuizService wordService;

    private final UserRepository userRepository;

    public UserController(@Autowired QuizService wordService, @Autowired UserRepository userRepository) {
        this.wordService = wordService;
        this.userRepository = userRepository;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User userToSave = userRepository.save(user);
            return new ResponseEntity<>(userToSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @GetMapping("/getWord")
//    public Word getString() {
//        Optional<Word> word = wordService.getWordById(1);
//        return word.orElse(null);
//    }

//    @GetMapping("/getAll")
//    public Collection<Word> getAll() {
//        return wordService.getAll();
//    }
}
