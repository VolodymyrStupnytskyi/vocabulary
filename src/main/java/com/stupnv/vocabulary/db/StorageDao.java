package com.stupnv.vocabulary.db;

import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.utils.StringEquality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StorageDao implements Dao<Word> {

    @Autowired
    private Storage storage;


    public Optional<Word> getByOriginal(String origin) {
        Optional<Word> optional = Optional.empty();
        for (Word word : storage.getWordStorage()) {
            if (StringEquality.isEquals(origin, word.getOriginal())) {
                return Optional.of(word);
            }
        }
        return optional;
    }

    @Override
    public Optional<Word> getById(int id) {
        Optional<Word> optional = Optional.empty();
        for (Word word : storage.getWordStorage()) {
            if (word.getId() == id) {
                return Optional.of(word);
            }
        }
        return optional;
    }

    @Override
    public Collection<Word> getAll() {
        return storage.getWordStorage();
    }

    @Override
    public int save(Word storage) {
        return 0;
    }

    @Override
    public void update(Word storage) {

    }

    @Override
    public void delete(Word storage) {

    }

    public Set<Word> getNUniqueItems(int i) throws Exception {
        Set<Word> words = new HashSet<>(i);
        int diff = i - storage.getWordStorage().size();
        if (diff > defaultSet().size()) {
            throw new Exception("There are no such number of items in the storage.");
        }

        if (diff > 0) {
            while (words.size() <= diff) {
                words.add(defaultSet().get((int) (Math.random() * (i + 1))));
            }
        }

        while (words.size() <= i) {
            words.add(storage.getWordStorage().get((int) (Math.random() * (i + 1))));
        }

        return words;
    }

    private static List<Word> defaultSet() {
        return List.of(
                new Word(97, "Car", "Автомобіль"),
                new Word(96, "Bicycle", "Велосипед"),
                new Word(95, "Tractor", "Трактор"),
                new Word(94, "Motorcycle", "Мотоцикл")
        );
    }
}
