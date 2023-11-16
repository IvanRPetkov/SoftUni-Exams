package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.WordAddBindingModel;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.dto.WordHomeViewModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    private WordRepository wordRepository;


    private LanguageRepository languageRepository;
    private UserRepository userRepository;
    private LoggedUser loggedUser;

    public WordServiceImpl(WordRepository wordRepository,
                           LanguageRepository languageRepository,
                           UserRepository userRepository,
                           LoggedUser loggedUser) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    public void add(WordAddBindingModel wordAddBindingModel) {
        Language language = languageRepository.findByName(wordAddBindingModel.getLanguage());

        if (language != null) {
            User user = userRepository.findByUsername(loggedUser.getUsername());

            Word word = new Word();
            word.setTerm(wordAddBindingModel.getTerm());
            word.setTranslation(wordAddBindingModel.getTranslation());
            word.setExample(wordAddBindingModel.getExample());
            word.setDate(LocalDate.parse(wordAddBindingModel.getInputDate()));
            word.setLanguage(language);
            word.setAddedBy(user);

            wordRepository.save(word);
        }
    }

    @Override
    public void removeOne(Long id) {
        Optional<Word> word = wordRepository.findById(id);
        LanguageName languageName = word.get().getLanguage().getName();

        WordHomeViewModel wordHomeViewModel = new WordHomeViewModel();

        switch (languageName) {
            case GERMAN -> wordHomeViewModel.getGermanWords().remove(word);
            case SPANISH -> wordHomeViewModel.getSpanishWords().remove(word);
            case FRENCH -> wordHomeViewModel.getFrenchWords().remove(word);
            case ITALIAN -> wordHomeViewModel.getItalianWords().remove(word);
        }

        wordRepository.deleteById(id);


    }

    @Override
    public void removeAll() {
        WordHomeViewModel wordHomeViewModel = new WordHomeViewModel();
        wordHomeViewModel.getGermanWords().clear();
        wordHomeViewModel.getFrenchWords().clear();
        wordHomeViewModel.getSpanishWords().clear();
        wordHomeViewModel.getItalianWords().clear();

        wordRepository.deleteAll();
    }

    @Override
    public WordHomeViewModel getHomeViewInfo() {

        List<WordDTO> allGermanWords = wordRepository.findAllByLanguageName(LanguageName.GERMAN)
                .stream()
                .map(WordDTO::createFromWord)
                .toList();

        List<WordDTO> allSpanishWords = wordRepository.findAllByLanguageName(LanguageName.SPANISH)
                .stream()
                .map(WordDTO::createFromWord)
                .toList();

        List<WordDTO> allFrenchWords = wordRepository.findAllByLanguageName(LanguageName.FRENCH)
                .stream()
                .map(WordDTO::createFromWord)
                .toList();

        List<WordDTO> allItalianWords = wordRepository.findAllByLanguageName(LanguageName.ITALIAN)
                .stream()
                .map(WordDTO::createFromWord)
                .toList();

        return new WordHomeViewModel(allGermanWords, allSpanishWords, allFrenchWords, allItalianWords);
    }
}
