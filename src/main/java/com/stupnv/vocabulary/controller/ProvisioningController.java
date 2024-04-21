package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.db.UserRepository;
import com.stupnv.vocabulary.model.User;
import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class ProvisioningController {

    private final WordService wordService;

    private final UserRepository userRepository;

    public ProvisioningController(@Autowired WordService wordService, @Autowired UserRepository userRepository) {
        this.wordService = wordService;
        this.userRepository = userRepository;
    }

    @GetMapping("/getWord")
    public Word getString() {
        Optional<Word> word = wordService.getWordById(1);
        return word.orElse(null);
    }

    @GetMapping("/getAll")
    public Collection<Word> getAll() {
        return wordService.getAll();
    }

    @GetMapping("/getUser")
    public User getUser() {
        Optional<User> user = userRepository.findById(1L);
        return user.orElse(null);
    }
}
