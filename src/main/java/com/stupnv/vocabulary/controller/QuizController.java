package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.model.Quiz;
import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class QuizController {
    private final WordService wordService;

    public QuizController(@Autowired WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/getQuiz")
    public Quiz getQuiz() {
        return wordService.getQuiz();
    }
}
