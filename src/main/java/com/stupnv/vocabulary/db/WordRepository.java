package com.stupnv.vocabulary.db;

import com.stupnv.vocabulary.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "SELECT w FROM Word w JOIN w.unit u JOIN u.user usr WHERE usr.id = :id", nativeQuery = true)
    Page<Word> findAllByUserId(@Param("id") Long id, Pageable pageable);
}
