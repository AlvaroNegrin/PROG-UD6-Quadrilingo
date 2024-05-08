package net.quadrilingo.dictionaries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private String letter;

    private Map<String, Set<String>> dictionary = new HashMap<>();

    public Dictionary() {
        for (int i = 97; i < 123; i++) {
            char letterAscii = (char) i;
            this.letter = "" + letterAscii;
            dictionary.put(letter, new HashSet<>());
        }
    }

    public void addWord(String word) {  
        String wordFormatted = formatText(word);
        String wordFirstLetter = Character.toString(wordFormatted.charAt(0));
        if (dictionary.containsKey(wordFirstLetter)) {
            dictionary.get(wordFirstLetter).add(wordFormatted);
        }
    }
    private String formatText(String text) {
        return text.toLowerCase().replaceAll("\\s", "");
    }

    @Override
    public String toString() {
        return "Diccionario [diccionario=" + dictionary + "]";
    }
}
