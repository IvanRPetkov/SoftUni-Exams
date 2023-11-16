package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.WordAddBindingModel;
import com.dictionaryapp.model.dto.WordHomeViewModel;

public interface WordService {
    void add(WordAddBindingModel wordAddBindingModel);

    void removeOne(Long id);

    void removeAll();

    WordHomeViewModel getHomeViewInfo();
}
