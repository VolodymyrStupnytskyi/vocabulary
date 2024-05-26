package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.db.UnitRepository;
import com.stupnv.vocabulary.db.UserRepository;
import com.stupnv.vocabulary.db.WordRepository;
import com.stupnv.vocabulary.model.Unit;
import com.stupnv.vocabulary.model.User;
import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class WordController {

    private final QuizService wordService;

    private final User user;

    private final UserRepository userRepository;

    private final UnitRepository unitRepository;

    private final WordRepository wordRepository;

    public WordController( //
                           @Autowired QuizService wordService, //
                           @Autowired User userProvider, //
                           @Autowired UnitRepository unitRepository, //
                           @Autowired UserRepository userRepository, //
                           @Autowired WordRepository wordRepository) {
        this.wordService = wordService;
        this.user = userProvider;
        this.userRepository = userRepository;
        this.unitRepository = unitRepository;
        this.wordRepository = wordRepository;
    }

    @GetMapping("/getDefaultUser")
    public ResponseEntity<User> getDefaultUser() {
        return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // /getAllWords?page=2&size=5
    @GetMapping("/getAllWords")
    public List<Word> getAllWords(Pageable pageable) {
        List<Word> allWords = user.getUnitList().stream()
                .flatMap(unit -> unit.getWordList().stream())
                .toList();
        PagedListHolder<Word> pagedListHolder = new PagedListHolder<>(allWords);
        pagedListHolder.setPageSize(pageable.getPageSize());
        pagedListHolder.setPage(pageable.getPageNumber());
        return pagedListHolder.getPageList();
    }

    @GetMapping("/getUnitWords/{id}")
    public ResponseEntity<List<Word>> getUnitWords(@PathVariable("id") Long id, Pageable pageable) {

        /*
        Optional<Unit> optionalUnit = unitRepository.findById(id);
        if (optionalUnit.isPresent()) {
            Unit unit = optionalUnit.get();
            if (Objects.equals(unit.getUser().getId(), user.getId())) {
                PagedListHolder<Word> pagedListHolder = new PagedListHolder<>(unit.getWordList());
                pagedListHolder.setPageSize(pageable.getPageSize());
                pagedListHolder.setPage(pageable.getPageNumber());
                return new ResponseEntity<>(pagedListHolder.getPageList(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         */

        return unitRepository.findById(id)
                .map(unit -> {
                    PagedListHolder<Word> pagedListHolder = new PagedListHolder<>(unit.getWordList());
                    pagedListHolder.setPageSize(pageable.getPageSize());
                    pagedListHolder.setPage(pageable.getPageNumber());
                    return new ResponseEntity<>(pagedListHolder.getPageList(), HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
