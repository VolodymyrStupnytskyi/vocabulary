package com.stupnv.vocabulary.service;

import com.stupnv.vocabulary.db.UnitRepository;
import com.stupnv.vocabulary.model.Unit;
import com.stupnv.vocabulary.model.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UnitServiceTest {

    @Mock
    UnitRepository unitRepository;

    @InjectMocks
    UnitService unitService;

    private final Long TEST_ID = 37L;

    @BeforeEach
    public void before() {
        Unit unit = new Unit();
        unit.setWordList(List.of(
                new Word("Dog", ""),
                new Word("Cat", ""),
                new Word("Mouse", ""),
                new Word("Frog", ""),
                new Word("Horse", "")
        ));
        when(unitRepository.findById(TEST_ID)).thenReturn(Optional.of(unit));
    }

    @Test
    void testGetNWords() {
        assertEquals(0, unitService.getNWords(TEST_ID, 0).size());
        assertEquals(5, unitService.getNWords(TEST_ID, 5).size());
        assertEquals(5, unitService.getNWords(TEST_ID, 7).size());
        assertEquals(4, unitService.getNWords(TEST_ID, 4).size());
        assertEquals(3, unitService.getNWords(TEST_ID, 3).size());
    }
}