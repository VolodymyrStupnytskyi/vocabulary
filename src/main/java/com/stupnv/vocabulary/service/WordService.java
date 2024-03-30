package com.stupnv.vocabulary.service;

import com.stupnv.vocabulary.db.StorageDao;
import com.stupnv.vocabulary.model.Quiz;
import com.stupnv.vocabulary.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordService {
    @Autowired
    private StorageDao storageDao;

    public Optional<Word> getByOriginal(String original) {
        return storageDao.getByOriginal(original);
    }

    public Optional<Word> getWordById(int id) {
        return storageDao.getById(id);
    }

    public Collection<Word> getAll() {
        return storageDao.getAll();
    }

    public Quiz getQuiz() {
        List<Word> words;
        try {
            words = new ArrayList<>(storageDao.getNUniqueItems(4));
        } catch (Exception e) {
            return null;
        }

        Quiz quiz = new Quiz();
        quiz.setQuizWord(words.get(0));
        Collections.shuffle(words);
        quiz.setOptionA(words.get(0));
        quiz.setOptionB(words.get(1));
        quiz.setOptionC(words.get(2));
        quiz.setOptionD(words.get(3));


        return quiz;

    }
}
