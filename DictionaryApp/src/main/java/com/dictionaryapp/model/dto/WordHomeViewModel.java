package com.dictionaryapp.model.dto;

import java.util.ArrayList;
import java.util.List;

public class WordHomeViewModel {

    private List<WordDTO> germanWords;

    private List<WordDTO> spanishWords;

    private List<WordDTO> frenchWords;

    private List<WordDTO> italianWords;

    private long germanWordsCount;
    private long spanishWordsCount;
    private long frenchWordsCount;
    private long italianWordsCount;

    private long totalWordsCount;

    public WordHomeViewModel() {
        this.germanWords = new ArrayList<>();
        this.spanishWords = new ArrayList<>();
        this.frenchWords = new ArrayList<>();
        this.italianWords = new ArrayList<>();
    }

    public WordHomeViewModel(List<WordDTO> german,
                             List<WordDTO> spanish,
                             List<WordDTO> french,
                             List<WordDTO> italian) {
        this.germanWords = german;
        this.spanishWords = spanish;
        this.frenchWords = french;
        this.italianWords = italian;
        this.germanWordsCount=german.size();
        this.spanishWordsCount=spanish.size();
        this.frenchWordsCount=french.size();
        this.italianWordsCount=italian.size();
        this.totalWordsCount =germanWords.size() + spanishWords.size() + frenchWords.size() + italianWords.size();
    }

    public List<WordDTO> getGermanWords() {
        return germanWords;
    }

    public List<WordDTO> getSpanishWords() {
        return spanishWords;
    }

    public List<WordDTO> getFrenchWords() {
        return frenchWords;
    }

    public List<WordDTO> getItalianWords() {
        return italianWords;
    }

    public long getGermanWordsCount() {
        return germanWordsCount;
    }

    public long getSpanishWordsCount() {
        return spanishWordsCount;
    }

    public long getFrenchWordsCount() {
        return frenchWordsCount;
    }

    public long getItalianWordsCount() {
        return italianWordsCount;
    }

    public long getTotalWordsCount() {
        return totalWordsCount;
    }

//    public void setTotalWordsCount() {
//        this.totalWordsCount = getGermanWordsCount() + getSpanishWordsCount() + getFrenchWordsCount() + getItalianWordsCount();
//    }
}
