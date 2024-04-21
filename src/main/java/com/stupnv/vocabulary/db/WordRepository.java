package com.stupnv.vocabulary.db;

import com.stupnv.vocabulary.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
