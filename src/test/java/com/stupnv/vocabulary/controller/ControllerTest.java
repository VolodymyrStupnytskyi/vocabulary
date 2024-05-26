package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.VocabularyApplication;
import com.stupnv.vocabulary.model.Word;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
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
        Map<String, String> params = new HashMap<String, String>();
        params.put("unitId", "1");

        ResponseEntity<List<Word>> response =
                testRestTemplate.exchange("/getQuiz/{unitId}",
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        }, params);
        List<Word> a = response.getBody();
        System.out.println(a);
    }
}
