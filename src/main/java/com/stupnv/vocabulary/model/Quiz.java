package com.stupnv.vocabulary.model;

public class Quiz {
    private Word quizWord;
    private Word optionA;
    private Word optionB;
    private Word optionC;
    private Word optionD;

    public Quiz() {
    }

    public void setQuizWord(Word quizWord) {
        this.quizWord = quizWord;
    }

    public void setOptionA(Word optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(Word optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(Word optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(Word optionD) {
        this.optionD = optionD;
    }

    public Word getQuizWord() {
        return quizWord;
    }

    public Word getOptionA() {
        return optionA;
    }

    public Word getOptionB() {
        return optionB;
    }

    public Word getOptionC() {
        return optionC;
    }

    public Word getOptionD() {
        return optionD;
    }
}
