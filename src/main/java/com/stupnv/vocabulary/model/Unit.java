package com.stupnv.vocabulary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(
        name = "unit"
)
public class Unit {
    @Id
    @SequenceGenerator(
            name = "unit_sequence",
            sequenceName = "unit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "unit_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "title"
    )
    @Nationalized
    String title;

    @OneToMany(mappedBy = "unit", fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Word> wordList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Unit(String title, User user) {
        this.title = title;
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public User getUser() {
        return user;
    }

    public Unit() {
    }
}
