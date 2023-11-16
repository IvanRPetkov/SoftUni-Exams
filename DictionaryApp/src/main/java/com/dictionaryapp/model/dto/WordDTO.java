package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

public class WordDTO {

    private Long id;

    private String term;

    private String translation;

    private String example;

    private String date;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static WordDTO createFromWord(Word word) {
        WordDTO wordDTO = new WordDTO();

        wordDTO.setId(word.getId());
        wordDTO.setTerm(word.getTerm());
        wordDTO.setTranslation(word.getTranslation());
        wordDTO.setExample(word.getExample());
        wordDTO.setDate(word.getDate().toString());
        wordDTO.setUser(word.getAddedBy());

        return wordDTO;
    }
}
