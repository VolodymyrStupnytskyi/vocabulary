package com.stupnv.vocabulary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.Objects;

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
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Word() {
    }

    public Word(String original, String translation, User user) {
        this.original = original;
        this.translation = translation;
        this.user = user;
    }

    public Word(String original, String transcription, String translation, String exampleOfUsage, User user) {
        this.original = original;
        this.transcription = transcription;
        this.translation = translation;
        this.exampleOfUsage = exampleOfUsage;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(original, word.original) && Objects.equals(transcription, word.transcription) && Objects.equals(translation, word.translation) && Objects.equals(exampleOfUsage, word.exampleOfUsage) && Objects.equals(user, word.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(original, transcription, translation, exampleOfUsage, user);
    }

    @Override
    public String toString() {
        return "Word{" +
                "original='" + original + '\'' +
                ", transcription='" + transcription + '\'' +
                ", translation='" + translation + '\'' +
                ", exampleOfUsage='" + exampleOfUsage + '\'' +
                ", user=" + user +
                '}';
    }
}
