package com.stupnv.vocabulary;

import com.stupnv.vocabulary.db.UserRepository;
import com.stupnv.vocabulary.db.WordRepository;
import com.stupnv.vocabulary.model.User;
import com.stupnv.vocabulary.model.Word;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VocabularyApplication {

    public static void main(String[] args) {
        SpringApplication.run(VocabularyApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        User user = new User("Oleg", "Kushnir", "oleg@gmail.com");

        List<Word> words = new ArrayList<>();
        words.add(new Word("Cat", "Кіт", user));
        words.add(new Word("Dog", "Собака", user));
        words.add(new Word("Horse", "Кінь", user));
        words.add(new Word("Frog", "[frɒɡ]", "Жаба", "This frog is green", user));


        user.setWordList(words);

        return args -> {
            userRepository.save(user);
        };
    }


//    @Bean
//    CommandLineRunner commandLineRunner(WordRepository wordRepository) {
//        return args -> {
//            wordRepository.save(new Word("Cat", "Кіт", null));
//            wordRepository.save(new Word("Dog", "Собака", null));
//            wordRepository.save(new Word("Horse", "Кінь", null));
////            wordRepository.save(new Word("Fish", "Риба"));
////            wordRepository.save(new Word("Bird", "Пташка"));
////            wordRepository.save(new Word("Mouse", "Миш"));
////            wordRepository.save(new Word("Lion", "Лев"));
////            wordRepository.save(new Word("Snake", "Змія"));
////            wordRepository.save(new Word("Cow", "Корова"));
////            wordRepository.save(new Word("Tiger", "Тигр"));
////            wordRepository.save(new Word("Wolf", "Вовк"));
////            wordRepository.save(new Word("Bear", "Ведмідь"));
////            wordRepository.save(new Word("Frog", "Жаба"));
////            wordRepository.save(new Word("Goat", "Коза"));
////            wordRepository.save(new Word("Camel", "Верблюд"));
////            wordRepository.save(new Word("Hedgehog", "Їжак"));
////            wordRepository.save(new Word("Hamster", "Хом'як"));
////            wordRepository.save(new Word("Sheep", "Вівця"));
////            wordRepository.save(new Word("Panda", "Панда"));
////            wordRepository.save(new Word("Monkey", "Мавпа"));
//        };
//    }

}
