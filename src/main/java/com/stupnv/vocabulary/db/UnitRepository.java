package com.stupnv.vocabulary.db;

import com.stupnv.vocabulary.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
