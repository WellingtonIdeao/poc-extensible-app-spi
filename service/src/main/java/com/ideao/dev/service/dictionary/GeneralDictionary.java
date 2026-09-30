package com.ideao.dev.service.dictionary;

import com.ideao.dev.service.spi.DictionaryProvider;

import java.util.SortedMap;
import java.util.TreeMap;

public class GeneralDictionary implements DictionaryProvider {
    private SortedMap<String, String> map;

    public GeneralDictionary() {
        this.map = new TreeMap<>();
        map.put(
                "book",
                "a set of written or printed pages, usually bound with " +
                        "a protective cover");
        map.put(
                "editor",
                "a person who edits");
    }

    @Override
    public String getDefinition(String word) {
        return map.get(word);
    }
}