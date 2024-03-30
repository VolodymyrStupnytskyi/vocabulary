package com.stupnv.vocabulary.db;

import com.stupnv.vocabulary.model.Word;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {

    private List<Word> wordStorage = new ArrayList<>();

    {
        wordStorage.add(new Word(1, "Cat", "Кіт"));
        wordStorage.add(new Word(2, "Dog", "Собака"));
        wordStorage.add(new Word(3, "Horse", "Кінь"));
        wordStorage.add(new Word(4, "Fish", "Риба"));
        wordStorage.add(new Word(5, "Bird", "Пташка"));
        wordStorage.add(new Word(6, "Mouse", "Миш"));
        wordStorage.add(new Word(7, "Lion", "Лев"));
        wordStorage.add(new Word(8, "Snake", "Змія"));
        wordStorage.add(new Word(9, "Cow", "Корова"));
        wordStorage.add(new Word(10, "Tiger", "Тигр"));
        wordStorage.add(new Word(11, "Wolf", "Вовк"));
        wordStorage.add(new Word(12, "Bear", "Ведмідь"));
        wordStorage.add(new Word(13, "Frog", "Жаба"));
        wordStorage.add(new Word(14, "Goat", "Коза"));
        wordStorage.add(new Word(15, "Camel", "Верблюд"));
        wordStorage.add(new Word(16, "Hedgehog", "Їжак"));
        wordStorage.add(new Word(17, "Hamster", "Хом'як"));
        wordStorage.add(new Word(18, "Sheep", "Вівця"));
        wordStorage.add(new Word(19, "Panda", "Панда"));
        wordStorage.add(new Word(20, "Monkey", "Мавпа"));
    }

    public List<Word> getWordStorage() {
        return wordStorage;
    }

    @Override
    public String toString() {
        return wordStorage.toString();
    }
}
