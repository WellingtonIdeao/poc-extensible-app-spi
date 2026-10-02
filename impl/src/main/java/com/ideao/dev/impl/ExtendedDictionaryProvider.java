package com.ideao.dev.impl;

import com.ideao.dev.service.dictionary.DictionaryManager;
import com.ideao.dev.service.spi.DictionaryProvider;

public class ExtendedDictionaryProvider implements DictionaryProvider {
    @Override
    public DictionaryManager create() {
        return new ExtendedManagerImpl();
    }
}