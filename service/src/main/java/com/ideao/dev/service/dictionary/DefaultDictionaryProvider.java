package com.ideao.dev.service.dictionary;

import com.ideao.dev.service.spi.DictionaryProvider;

public class DefaultDictionaryProvider implements DictionaryProvider {
    @Override
    public DictionaryManager create() {
        return new DefaultDictionaryManagerImpl();
    }
}