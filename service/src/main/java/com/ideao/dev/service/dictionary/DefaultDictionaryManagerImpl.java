package com.ideao.dev.service.dictionary;

import java.util.SortedMap;
import java.util.TreeMap;

public class DefaultDictionaryManagerImpl implements DictionaryManager {
    private Dictionary dictionary;

    public DefaultDictionaryManagerImpl() {
        this.dictionary = new Dictionary();
        SortedMap<String, String> map = new TreeMap<>();
        map.put(
                "book",
                "a set of written or printed pages, usually bound with " +
                        "a protective cover");
        map.put(
                "editor",
                "a person who edits");
        this.dictionary.setMap(map);
    }

    @Override
    public Dictionary getDictionary() {
       return dictionary;
    }
}