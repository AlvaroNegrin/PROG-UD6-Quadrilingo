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
                System.out.println("Introduzca la palabra a eliminar");
                userText = SC.nextLine();
                dictionary.deleteWord(userText);
                break;
            case "3":
                System.out.println("Introduzca la palabra a buscar");
                userText = SC.nextLine();
                System.out.println(dictionary.showWordIfExists(userText));
                break;
            case "4":
                dictionary.showInitialsWithInfo();
                break;
            case "5":
                System.out.println("Introduzca la inicial de una letra para buscar las palabras que comiencen por dicha letra");
                userText = SC.nextLine();
                dictionary.showWordsByInitial(userText);
                break;
            case "6":
                setKeepAsking(false);
                System.out.println("¡Adios! \n¡Gracias por usar nuestro programa!");
                break;

            default:
                break;
        }
    }
}
