package com.stupnv.vocabulary.model;

public class Word {

    private int id;

    private String original;

    private String transcription;

    private String translation;

    private String exampleOfUsage;

    public Word() {
    }

    public Word(int id, String original, String translation) {
        this.id = id;
        this.original = original;
        this.translation = translation;
    }

    public Word(int id, String original, String transcription, String translation, String exampleOfUsage) {
        this.id = id;
        this.original = original;
        this.transcription = transcription;
        this.translation = translation;
        this.exampleOfUsage = exampleOfUsage;
    }

    public String getOriginal() {
        return original;
    }

    public String getTranscription() {
        return transcription;
    }

    public String getTranslation() {
        return translation;
    }

    public String getExampleOfUsage() {
        return exampleOfUsage;
    }

    public int getId() {
        return id;
    }

}
