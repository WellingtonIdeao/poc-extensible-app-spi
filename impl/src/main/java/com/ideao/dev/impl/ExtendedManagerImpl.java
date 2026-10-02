package com.ideao.dev.impl;

import com.ideao.dev.service.dictionary.Dictionary;
import com.ideao.dev.service.dictionary.DictionaryManager;

import java.util.SortedMap;
import java.util.TreeMap;

public class ExtendedManagerImpl  implements DictionaryManager {
    private Dictionary dictionary;

    public ExtendedManagerImpl() {
        this.dictionary = new Dictionary();
        SortedMap<String, String> map = new TreeMap<>();
        map.put(
                "xml",
                "a document standard often used in web services, among other " +
                        "things");
        map.put(
                "REST",
                "an architecture style for creating, reading, updating, " +
                        "and deleting data that attempts to use the common " +
                        "vocabulary of the HTTP protocol; Representational State " +
                        "Transfer");
        this.dictionary.setMap(map);
    }

    @Override
    public Dictionary getDictionary() {
        return dictionary;
    }
}