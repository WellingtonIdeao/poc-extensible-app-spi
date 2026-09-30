package com.ideao.dev.client;

import com.ideao.dev.service.bootstrap.DictionaryService;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello Client!");

        DictionaryService service = DictionaryService.getInstance();

        String word = "xml";
        String definition = service.getDefinition(word);
        if (definition == null) {
            System.out.println(word  + ": Cannot find definition for this word.");
        } else {
            System.out.println(word + ": " + definition);
        }
    }
}
