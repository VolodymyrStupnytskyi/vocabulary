package com.stupnv.vocabulary.db;

import com.stupnv.vocabulary.model.Word;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {

    private List<Word> wordStorage = new ArrayList<>();

//    {
//        wordStorage.add(new Word(1L, "Cat", "Кіт"));
//        wordStorage.add(new Word(2L, "Dog", "Собака"));
//        wordStorage.add(new Word(3L, "Horse", "Кінь"));
//        wordStorage.add(new Word(4L, "Fish", "Риба"));
//        wordStorage.add(new Word(5L, "Bird", "Пташка"));
//        wordStorage.add(new Word(6L, "Mouse", "Миш"));
//        wordStorage.add(new Word(7L, "Lion", "Лев"));
//        wordStorage.add(new Word(8L, "Snake", "Змія"));
//        wordStorage.add(new Word(9L, "Cow", "Корова"));
//        wordStorage.add(new Word(10L, "Tiger", "Тигр"));
//        wordStorage.add(new Word(11L, "Wolf", "Вовк"));
//        wordStorage.add(new Word(12L, "Bear", "Ведмідь"));
//        wordStorage.add(new Word(13L, "Frog", "Жаба"));
//        wordStorage.add(new Word(14L, "Goat", "Коза"));
//        wordStorage.add(new Word(15L, "Camel", "Верблюд"));
//        wordStorage.add(new Word(16L, "Hedgehog", "Їжак"));
//        wordStorage.add(new Word(17L, "Hamster", "Хом'як"));
//        wordStorage.add(new Word(18L, "Sheep", "Вівця"));
//        wordStorage.add(new Word(19L, "Panda", "Панда"));
//        wordStorage.add(new Word(20L, "Monkey", "Мавпа"));
//    }

    public List<Word> getWordStorage() {
        return wordStorage;
    }

    @Override
    public String toString() {
        return wordStorage.toString();
    }
}
