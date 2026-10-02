package com.ideao.dev.service.bootstrap;

import com.ideao.dev.service.dictionary.Dictionary;
import com.ideao.dev.service.spi.DictionaryProvider;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class DictionaryService {

    private static final String DEFAULT_PROVIDER = "com.ideao.dev.service.dictionary.DefaultDictionaryProvider";


    private DictionaryService() {}

    public static List<DictionaryProvider> providers() {
        List<DictionaryProvider> providers = new ArrayList<>();

        ServiceLoader<DictionaryProvider> loader = ServiceLoader.load(DictionaryProvider.class);
        loader.forEach(dictionaryProvider -> {
            providers.add(dictionaryProvider);
        });
        return  providers;
    }
    public static DictionaryProvider provider() {
        return provider(DEFAULT_PROVIDER);
    }

    public static DictionaryProvider provider(String providerName) {
        ServiceLoader<DictionaryProvider> loader = ServiceLoader.load(DictionaryProvider.class);
        Iterator<DictionaryProvider> it = loader.iterator();

        while (it.hasNext()) {
            DictionaryProvider provider = it.next();
            if (providerName.equals(provider.getClass().getName())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException("DictionaryProvider " + providerName + " not found.");
    }

    public static List<Dictionary> getDictionaries() {
        List<Dictionary> dictionaries = new ArrayList<>();
        List<DictionaryProvider> providers = providers();
        for (DictionaryProvider provider: providers) {
            Dictionary dict = provider.create().getDictionary();
            dictionaries.add(dict);
        }
        return dictionaries;
    }

    public static String getDefinition(String word) {
        List<DictionaryProvider> providers = providers();
        String definition = null;

        for (DictionaryProvider provider : providers) {
            Dictionary dict = provider.create().getDictionary();
            definition = dict.getDefinition(word);
            if (definition != null) {
                break;
            }
        }
        return definition;
    }

    public static String getDefaultDefinition(String word) {
        DictionaryProvider provider = provider();
        Dictionary dictionary = provider.create().getDictionary();
        return  dictionary.getDefinition(word);
    }
}