package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.VocabularyApplication;
import com.stupnv.vocabulary.model.Quiz;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;

@ExtendWith(SpringExtension.class)
@Disabled
@SpringBootTest(classes = VocabularyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getAll() {
        ResponseEntity<Collection> response = testRestTemplate.getForEntity("/getAll", Collection.class);
        Collection storage = response.getBody();
        System.out.println(storage);
    }

    @Test
    void getQuiz() {
        ResponseEntity<Quiz> response = testRestTemplate.getForEntity("/getQuiz", Quiz.class);
        Quiz quiz = response.getBody();
        System.out.println(quiz);
    }
}
