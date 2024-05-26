package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.model.User;
import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {
    private final QuizService quizService;

    private final User user;

    public QuizController(@Autowired QuizService quizService, @Autowired User userProvider) {
        this.quizService = quizService;
        this.user = userProvider;
    }

    @GetMapping("/getQuiz/{unitId}")
    public List<Word> getQuiz(@PathVariable("unitId") Long unitId) {
        return (unitId != null) ? quizService.getQuiz(user) : quizService.getQuiz(unitId);
    }
}
