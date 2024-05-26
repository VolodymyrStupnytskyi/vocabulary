package com.stupnv.vocabulary.service;

import com.stupnv.vocabulary.db.UnitRepository;
import com.stupnv.vocabulary.exception.NoUnitFoundException;
import com.stupnv.vocabulary.model.Unit;
import com.stupnv.vocabulary.model.Word;
import com.stupnv.vocabulary.utils.ListUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Word> getNWords(long id, int count) {
       return ListUtils.getNElemetsFromList(getUnitById(id).getWordList(), count);
    }

    public List<Word> getNWords(Unit unit, int count) {
        return ListUtils.getNElemetsFromList(unit.getWordList(), count);
    }

    public Unit getUnitById(long id) {
        return unitRepository.findById(id).orElseThrow(NoUnitFoundException::new);
    }

    public List<Word> getAllUnitWords(long id) {
        return getUnitById(id).getWordList();
    }
}
