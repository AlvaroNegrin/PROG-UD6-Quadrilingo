package net.quadrilingo.dictionaries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private String letter;
    private Set<String> wordsCollection = new HashSet<>();

    private Map<String, Set<String>> dictionary = new HashMap<>();

    public Dictionary() {
    }

    public void createDictionary() {
        for (int i = 97; i < 123; i++) {
            char letterAscii = (char) i;
            this.letter = "" + letterAscii;
            dictionary.put(letter, this.wordsCollection);
        }
    }

    @Override
    public String toString() {
        return "Diccionario [diccionario=" + dictionary + "]";
    }
}
