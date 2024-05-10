package net.quadrilingo.dictionaries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.quadrilingo.decorationstuff.ConsoleColors;

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
        if (!this.containsNumber(word) && word.length() > 0) {
            String wordFormatted = this.formatText(word);
            String wordFirstLetter = Character.toString(wordFormatted.charAt(0));
            if (dictionary.containsKey(wordFirstLetter)) {
                dictionary.get(wordFirstLetter).add(wordFormatted);
                System.out.println(ConsoleColors.changeAnsiBoldColor("Su palabra " + ConsoleColors.ANSI_ORANGE + 
                wordFormatted + ConsoleColors.ANSI_GREEN + " se ha añadido correctamente", ConsoleColors.ANSI_GREEN));
            }
        } else {
            System.out.println(ConsoleColors.changeAnsiBoldColor("La palabra no es valida", 
            ConsoleColors.ANSI_RED));
        }
    }

    public void deleteWord(String word) {
        if (!this.containsNumber(word) && word.length() > 0) {
            String wordFormatted = this.formatText(word);
            String wordFirstLetter = Character.toString(wordFormatted.charAt(0));

            if (dictionary.containsKey(wordFirstLetter) && dictionary.get(wordFirstLetter).contains(wordFormatted)) {
                dictionary.get(wordFirstLetter).remove(wordFormatted);

                System.out.println(ConsoleColors.changeAnsiBoldColor("Su palabra " + ConsoleColors.ANSI_ORANGE + wordFormatted + ConsoleColors.ANSI_GREEN + " se ha eliminado correctamente", ConsoleColors.ANSI_GREEN));
            } else {
                System.out.println(ConsoleColors.changeAnsiBoldColor("Su palabra no se encuentra en el diccionario", 
                ConsoleColors.ANSI_RED));
            }
        } else {
            System.out.println(ConsoleColors.changeAnsiBoldColor("La palabra no es valida", 
            ConsoleColors.ANSI_RED));
        }
    }

    public String showWordIfExists(String word) {
        if (!this.containsNumber(word) && word.length() > 0) {
            String wordFormatted = formatText(word);
            String wordFirstLetter = Character.toString(wordFormatted.charAt(0));

            return dictionary.get(wordFirstLetter).contains(wordFormatted) ? 
            ConsoleColors.changeAnsiBoldColor("¡Se ha encontrado la palabra " + ConsoleColors.ANSI_ORANGE + 
            wordFormatted + ConsoleColors.ANSI_GREEN + " en el diccionario!", ConsoleColors.ANSI_GREEN) : 
            ConsoleColors.changeAnsiBoldColor( "La palabra " + ConsoleColors.ANSI_YELLOW + wordFormatted + 
            ConsoleColors.ANSI_RED + " no esta en el diccionario.", ConsoleColors.ANSI_RED);
        }
        return ConsoleColors.changeAnsiBoldColor("La palabra no es valida", ConsoleColors.ANSI_RED);
    }

    public void showInitialsWithInfo() {
        String initialsWithInfo = "";

        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                initialsWithInfo += ConsoleColors.ANSI_ORANGE + "- " + 
                ConsoleColors.ANSI_YELLOW + entry.getKey() + ConsoleColors.ANSI_RESET +"\n";
            }
        }
        if (initialsWithInfo == "") {
            System.out.println(ConsoleColors.changeAnsiBoldColor("No hay ninguna inicial que contenga palabras", ConsoleColors.ANSI_ORANGE));
        } else {
            System.out.println(ConsoleColors.changeAnsiColor("Estas son las iniciales que contienen alguna palabra:", ConsoleColors.ANSI_GREEN));
            System.out.println(initialsWithInfo);
        }
    }

    public void showWordsByInitial(String letter) {
        String letterFormatted = this.formatText(letter);
        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(letterFormatted)) {
                if (entry.getValue().isEmpty()) {
                    System.out.println(ConsoleColors.changeAnsiBoldColor("Lo siento maquina, esta vacia la lista ;)", ConsoleColors.ANSI_YELLOW));
                } else {
                    System.out.println(ConsoleColors.changeAnsiColor("Lista de la letra " + ConsoleColors.ANSI_RED
                    + letterFormatted + ConsoleColors.ANSI_YELLOW + ":\n", ConsoleColors.ANSI_YELLOW) + entry.getValue());
                }
            } else if (letter.length() == 0) {
                System.out.println(ConsoleColors.changeAnsiBoldColor("La letra no es valida", ConsoleColors.ANSI_RED));
                break;
            }
        }

    }

    private String formatText(String text) {
        return text.toLowerCase().replaceAll("\\s", "");
    }

    private boolean containsNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
