package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProvisioningController {

    private final WordService wordService;

    public ProvisioningController(@Autowired WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/getWord")
    public Word getString() {
        Optional<Word> word = wordService.getWordById(1);
        return word.orElse(null);
    }
}
