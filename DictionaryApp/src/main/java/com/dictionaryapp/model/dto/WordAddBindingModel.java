package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.annotation.StringDateInThePastOrPresent;
import com.dictionaryapp.model.enums.LanguageName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WordAddBindingModel {

    @Size(min = 2, max = 50, message = "The term length must be between 2 and 40 characters!")
    private String term;

    @Size(min = 2, max = 80, message = "The translation length must be between 2 and 40 characters!")
    private String translation;

    @Size(min = 2, max = 200, message = "The example length must be between 2 and 200 characters!")
    private String example;

    @StringDateInThePastOrPresent(message = "The input date must be in the past or present!")
    private String inputDate;

    @NotNull(message = "You must select a language!")
    private LanguageName language;

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

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public LanguageName getLanguage() {
        return language;
    }

    public WordAddBindingModel setLanguage(LanguageName language) {
        this.language = language;
        return this;
    }
}

