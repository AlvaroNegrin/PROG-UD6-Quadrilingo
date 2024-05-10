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
        String wordFormatted = this.formatText(word);
        String wordFirstLetter = Character.toString(wordFormatted.charAt(0));
        if (dictionary.containsKey(wordFirstLetter)) {
            dictionary.get(wordFirstLetter).add(wordFormatted);
            System.out.println("Su palabra " + wordFormatted + " se ha añadido correctamente");
        }
    }

    public void deleteWord(String word) {
        String wordFormatted = this.formatText(word);
        String wordFirstLetter = Character.toString(wordFormatted.charAt(0));
        if (dictionary.containsKey(wordFirstLetter)) {
            dictionary.get(wordFirstLetter).remove(wordFormatted);
            System.out.println("Su palabra " + wordFormatted + " se ha eliminado correctamente");
        } else {
            System.out.println("Su palabra no se encuentra en el diccionario");
        }
    }

    public String showWordIfExists(String word) {
        String wordFormatted = formatText(word);
        String wordFirstLetter = Character.toString(wordFormatted.charAt(0));
        return dictionary.get(wordFirstLetter).contains(wordFormatted)
                ? "¡Se ha encontrado la palabra " + wordFormatted + " en el diccionario!"
                : "La palabra " + wordFormatted + " no esta en el diccionario.";
    }

    public void showInitialsWithInfo() {
        String initialsWithInfo = "";

        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                initialsWithInfo += entry.getKey() + ",";
            }
        }
        if (initialsWithInfo == "") {
            System.out.println("No hay ninguna inicial que contenga palabras");
        } else {
            System.out.println("Estas son las iniciales que contienen alguna palabra:");
            System.out.println(initialsWithInfo);
        }
    }

    public void showWordsByInitial(String letter) {
        String letterFormatted = this.formatText(letter);
        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(letterFormatted)) {
                if (entry.getValue().isEmpty()) {
                    System.out.println("Lo siento maquina, esta vacia la lista");
                } else {
                    System.out.println("Lista de la letra " + letterFormatted + ":\n" + entry.getValue());
                }
            }
        }

    }

    private String formatText(String text) {
        return text.toLowerCase().replaceAll("\\s", "");
    }
}
