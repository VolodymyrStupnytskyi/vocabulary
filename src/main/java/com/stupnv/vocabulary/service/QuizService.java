package com.stupnv.vocabulary.service;

import com.stupnv.vocabulary.model.Unit;
import com.stupnv.vocabulary.model.User;
import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final UnitService unitService;

    public QuizService(@Autowired UnitService unitService) {
        this.unitService = unitService;
    }

    public List<Word> getQuiz(long id) {
        return fillQuizWords(unitService.getNWords(id, 4));
    }

    public List<Word> getQuiz(User user) {
        List<Word> allWords = new ArrayList<>();
        for (Unit unit : user.getUnitList()) {
            allWords.addAll(unit.getWordList());
        }

        return fillQuizWords(ListUtils.getNElemetsFromList(allWords, 4));
    }

    private List<Word> fillQuizWords(List<Word> quizWords) {
        int diff = 4 - quizWords.size();
        if (diff > 0) {
            quizWords.addAll(ListUtils.getNElemetsFromList(fallbackWords, diff));
        }
        return quizWords;
    }

    private static final List<Word> fallbackWords = List.of(
      new Word("Dog", "Собака"),
      new Word("Car", "Автомобіль"),
      new Word("Doctor", "Лікар"),
      new Word("Flower", "Квітка"),
      new Word("Water", "Вода"),
      new Word("Engine", "Двигун"),
      new Word("Cup", "Чашка"),
      new Word("Star", "Кубок"),
      new Word("Wall", "Стіна")
    );


}
