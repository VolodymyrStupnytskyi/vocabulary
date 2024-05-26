package com.stupnv.vocabulary.controller;

import com.stupnv.vocabulary.db.UnitRepository;
import com.stupnv.vocabulary.db.UserRepository;
import com.stupnv.vocabulary.exception.NoUnitFoundException;
import com.stupnv.vocabulary.model.Unit;
import com.stupnv.vocabulary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UnitController {

    private final UserRepository userRepository;

    private final UnitRepository unitRepository;

    private final User user;

    public UnitController(@Autowired UserRepository userRepository, @Autowired UnitRepository unitRepository, @Autowired User user) {
        this.userRepository = userRepository;
        this.unitRepository = unitRepository;
        this.user = user;
    }

    @PostMapping("/createUnit")
    public ResponseEntity<Unit> createUnit(String title) throws Exception {
        Unit unit = new Unit(title, user);
        user.addUnit(unit);
        userRepository.save(user);
        return new ResponseEntity<>(unit, HttpStatus.CREATED);
    }

    @PostMapping("/readUnit/{id}")
    public ResponseEntity<Unit> readUnit(@PathVariable("id") Long id) {
        Optional<Unit> unit = unitRepository.findById(id);
        return unit.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateUnit/{id}/{title}")
    public ResponseEntity<Unit> updateUnit(@PathVariable("id") Long id, @PathVariable("title") String newTitle) {
        Unit unit = unitRepository.findById(id).orElseThrow(NoUnitFoundException::new);
        unit.setTitle(newTitle);
        unitRepository.save(unit);
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUnit(@PathVariable("id") Long id) {
        try {
            unitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
