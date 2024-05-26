package com.stupnv.vocabulary;

import com.stupnv.vocabulary.db.UserRepository;
import com.stupnv.vocabulary.db.WordRepository;
import com.stupnv.vocabulary.exception.NoUserFoundException;
import com.stupnv.vocabulary.model.Unit;
import com.stupnv.vocabulary.model.User;
import com.stupnv.vocabulary.model.Word;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class VocabularyApplication {

    public static void main(String[] args) {
        SpringApplication.run(VocabularyApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) throws Exception {
//        User user = new User("Oleg", "Kushnir", "oleg@gmail.com");
//
//        Unit unit = new Unit("My first List", user);
//        user.addUnit(unit);
//
//        List<Word> words = new ArrayList<>();
//        words.add(new Word("Cat", "Кіт", unit));
//        words.add(new Word("Dog", "Собака", unit));
//        words.add(new Word("Horse", "Кінь", unit));
//        words.add(new Word("Frog", "[frɒɡ]", "Жаба", "This frog is green", unit));
//
//
//        unit.setWordList(words);
//
//        return args -> {
//            userRepository.save(user);
//        };
//    }

    @Bean
    User userProvider(UserRepository userRepository) throws Exception {
        User user = new User("Ivan", "Kushnir", "oleg@gmail.com");

        Unit unit = new Unit("My first List", user);
        user.addUnit(unit);

        List<Word> words = new ArrayList<>();
        words.add(new Word("Cat", "Кіт", unit));
        words.add(new Word("Dog", "Собака", unit));
        words.add(new Word("Horse", "Кінь", unit));
        words.add(new Word("Frog", "[frɒɡ]", "Жаба", "This frog is green", unit));
        words.add(new Word("Cat", "Кіт", unit));
        words.add(new Word("Dog", "Собака", unit));
        words.add(new Word("Horse", "Кінь", unit));
        words.add(new Word("Fish", "Риба", unit));
        words.add(new Word("Bird", "Пташка, unit"));
        words.add(new Word("Mouse", "Миш", unit));
        words.add(new Word("Lion", "Лев", unit));
        words.add(new Word("Snake", "Змія", unit));
        words.add(new Word("Cow", "Корова", unit));
        words.add(new Word("Tiger", "Тигр", unit));
        words.add(new Word("Wolf", "Вовк", unit));
        words.add(new Word("Bear", "Ведмідь", unit));
        words.add(new Word("Frog", "Жаба", unit));
        words.add(new Word("Goat", "Коза", unit));
        words.add(new Word("Camel", "Верблюд", unit));
        words.add(new Word("Hedgehog", "Їжак", unit));
        words.add(new Word("Hamster", "Хом'як", unit));
        words.add(new Word("Sheep", "Вівця", unit));
        words.add(new Word("Panda", "Панда", unit));
        words.add(new Word("Monkey", "Мавпа", unit));
        unit.setWordList(words);
        return user;
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) throws Exception {
        User user = new User("Oleg", "Kushnir", "oleg@gmail.com");
        Unit unit = new Unit("My first List", user);

        List<Word> words = new ArrayList<>();
        words.add(new Word("Cat", "Кіт", unit));
        words.add(new Word("Dog", "Собака", unit));
        words.add(new Word("Horse", "Кінь", unit));
        words.add(new Word("Fish", "Риба", unit));
        words.add(new Word("Bird", "Пташка", unit));
        words.add(new Word("Mouse", "Миш", unit));
        words.add(new Word("Lion", "Лев", unit));
        words.add(new Word("Snake", "Змія", unit));
        words.add(new Word("Cow", "Корова", unit));
        words.add(new Word("Tiger", "Тигр", unit));
        words.add(new Word("Wolf", "Вовк", unit));
        words.add(new Word("Bear", "Ведмідь", unit));
        words.add(new Word("Frog", "Жаба", unit));
        words.add(new Word("Goat", "Коза", unit));
        words.add(new Word("Camel", "Верблюд", unit));
        words.add(new Word("Hedgehog", "Їжак", unit));
        words.add(new Word("Hamster", "Хом'як", unit));
        words.add(new Word("Sheep", "Вівця", unit));
        words.add(new Word("Panda", "Панда", unit));
        words.add(new Word("Monkey", "Мавпа", unit));

        unit.setWordList(words);

        user.addUnit(unit);

        return args -> {
            userRepository.save(user);
        };
    }

}
