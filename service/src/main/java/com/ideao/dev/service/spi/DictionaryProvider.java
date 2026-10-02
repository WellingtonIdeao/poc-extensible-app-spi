package com.ideao.dev.service.spi;

import com.ideao.dev.service.dictionary.DictionaryManager;

public interface DictionaryProvider {
    DictionaryManager create();
}