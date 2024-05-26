package com.stupnv.vocabulary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.Objects;
// TODO: Add supporting of several meanings and corresponding example of usages
@Entity()
@Table(name = "word")
public class Word {
    @Id
    @SequenceGenerator(
            name = "word_sequence",
            sequenceName = "word_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "word_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "original",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String original;

    @Column(
            name = "transcription"
    )
    @Nationalized
    private String transcription;

    @Column(
            name = "translation",
            nullable = false
    )
    @Nationalized
    private String translation;

    @Column(
            name = "example_of_usage",
            columnDefinition = "TEXT"
    )
    private String exampleOfUsage;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    @JsonIgnore
    private Unit unit;

    public Word() {
    }

    public Word(String original, String translation) {
        this.original = original;
        this.translation = translation;
    }

    public Word(String original, String translation, Unit unit) {
        this.original = original;
        this.translation = translation;
        this.unit = unit;
    }

    public Word(String original, String transcription, String translation, String exampleOfUsage, Unit unit) {
        this.original = original;
        this.transcription = transcription;
        this.translation = translation;
        this.exampleOfUsage = exampleOfUsage;
        this.unit = unit;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExampleOfUsage() {
        return exampleOfUsage;
    }

    public void setExampleOfUsage(String exampleOfUsage) {
        this.exampleOfUsage = exampleOfUsage;
    }


    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, original, transcription, translation, exampleOfUsage, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(original, word.original) && Objects.equals(transcription, word.transcription) && Objects.equals(translation, word.translation) && Objects.equals(exampleOfUsage, word.exampleOfUsage) && Objects.equals(unit, word.unit);
    }

    @Override
    public String toString() {
        return "Word{" +
                "original='" + original + '\'' +
                ", transcription='" + transcription + '\'' +
                ", translation='" + translation + '\'' +
                ", exampleOfUsage='" + exampleOfUsage + '\'' +
                ", unit=" + unit +
                '}';
    }
}
