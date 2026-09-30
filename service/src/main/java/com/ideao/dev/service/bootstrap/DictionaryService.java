package com.ideao.dev.service.bootstrap;

import com.ideao.dev.service.spi.DictionaryProvider;

import java.util.Iterator;
import java.util.ServiceLoader;

public class DictionaryService {
    private static final DictionaryService SERVICE = new DictionaryService();
    private final ServiceLoader<DictionaryProvider> loader;

    private DictionaryService(){
        this.loader = ServiceLoader.load(DictionaryProvider.class);
    }

    public static DictionaryService getInstance() {
        return SERVICE;
    }

    public String getDefinition(String word) {
        String definition = null;
        Iterator<DictionaryProvider> it = loader.iterator();

        while (it.hasNext()) {
           DictionaryProvider dictProvider = it.next();
           definition = dictProvider.getDefinition(word);
           if (definition != null) {
               break;
           }
        }
        return definition;
    }
}