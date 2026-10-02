package com.ideao.dev.service.dictionary;

import java.util.SortedMap;

public class Dictionary {
    SortedMap<String, String> map;

    public Dictionary(){}

    public Dictionary(SortedMap<String, String> map) {
        this.map = map;
    }

    public String getDefinition(String word) {
        return map.get(word);
    }

    public void setMap(SortedMap<String, String> map) {
        this.map = map;
    }
}