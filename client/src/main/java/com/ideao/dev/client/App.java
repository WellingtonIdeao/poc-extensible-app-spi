package com.ideao.dev.client;

import com.ideao.dev.service.bootstrap.DictionaryService;
import com.ideao.dev.service.dictionary.Dictionary;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello Client!");


        String word = "book";
        String definition = DictionaryService.getDefinition(word);
//        String definition = DictionaryService.getDefaultDefinition(word);
        if (definition == null) {
            System.out.println(word  + ": Cannot find definition for this word.");
        } else {
            System.out.println(word + ": " + definition);
        }

        for (Dictionary dictionary : DictionaryService.getDictionaries()) {
             definition = dictionary.getDefinition(word);

            if (definition != null) {
                System.out.println(word + ": " + definition);
                break;
            }
        }
    }
}