package com.stupnv.vocabulary.service;

import com.stupnv.vocabulary.model.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    private final List<Word> wordList;

    public WordService() {
        wordList = new ArrayList<>();
        Word word = new Word(1, "Cat", "Кіт");
        wordList.add(word);
    }

    public Optional<Word> getWordById(int id) {
        Optional<Word> optional = Optional.empty();
        for (Word word : wordList) {
            if (word.getId() == id) {
                return Optional.of(word);
            }
        }
        return optional;
    }
}
