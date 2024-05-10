package net.quadrilingo.menu;

import java.util.Scanner;

import net.quadrilingo.dictionaries.Dictionary;

public class Menu {
    private static boolean keepAsking;
    private static Dictionary dictionary = new Dictionary();
    private static final Scanner SC = new Scanner(System.in);

    public static boolean isKeepAsking() {
        return keepAsking;
    }
    public static void setKeepAsking(boolean keepAsking) {
        Menu.keepAsking = keepAsking;
    }   


    public static void showMainMenu() {
        String message = """
                ************************************
                * 1. Añadir Palabra                *
                * 2. Eliminar Palabra              *
                * 3. Palabra Existente             *
                * 4. Mostrar iniciales disponibles *
                * 5. Ver palabras por inicial      *
                * 6. Cerrar programa.              *
                ************************************
                """;
        System.out.println(message);
    }

    public static void optionMenu() {
        String userText;
        switch (SC.nextLine()) {
            case "1":
                System.out.println("Introduzca la palabra para añadir");
                userText = SC.nextLine();
                dictionary.addWord(userText);
                break;
            case "2":
                
                break;
            case "3":
                
                break;
            case "4":
                
                break;
            case "5":
                
                break;
            case "6":
                
                break;
        
            default:
                break;
        }
    }
}









