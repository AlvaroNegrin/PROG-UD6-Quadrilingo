package net.quadrilingo.menu;

import java.util.Scanner;

import net.quadrilingo.decorationstuff.ConsoleColors;
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
        final String BORDER_MENU = "\n************************************\n";
        final String OPTIONS_MENU = """
                * 1. Añadir Palabra                *
                * 2. Eliminar Palabra              *
                * 3. Palabra Existente             *
                * 4. Mostrar iniciales disponibles *
                * 5. Ver palabras por inicial      *
                * 6. Cerrar programa.              *
                """;

        System.out.println(ConsoleColors.changeAnsiBoldColor(BORDER_MENU, ConsoleColors.ANSI_BLUE) +  
        ConsoleColors.changeAnsiColor(OPTIONS_MENU, ConsoleColors.ANSI_CYAN) + 
        ConsoleColors.changeAnsiBoldColor(BORDER_MENU, ConsoleColors.ANSI_BLUE));
    };

    public static void optionMenu() {
        String userText;
        switch (SC.nextLine()) {
            case "1":
                System.out.println(ConsoleColors.changeAnsiColor("Introduzca la palabra para añadir", 
                ConsoleColors.ANSI_YELLOW));
                userText = SC.nextLine();
                dictionary.addWord(userText);
                break;
            case "2":
                System.out.println(ConsoleColors.changeAnsiColor("Introduzca la palabra a eliminar", 
                ConsoleColors.ANSI_YELLOW));
                userText = SC.nextLine();
                dictionary.deleteWord(userText);
                break;
            case "3":
                System.out.println(ConsoleColors.changeAnsiColor("Introduzca la palabra a buscar", 
                ConsoleColors.ANSI_YELLOW));
                userText = SC.nextLine();
                System.out.println(dictionary.showWordIfExists(userText));
                break;
            case "4":
                dictionary.showInitialsWithInfo();
                break;
            case "5":
                System.out.println(ConsoleColors.changeAnsiColor("Introduzca la inicial de una letra\nSe procederá a buscarla en el diccionario.", ConsoleColors.ANSI_YELLOW));
                userText = SC.nextLine();
                dictionary.showWordsByInitial(userText);
                break;
            case "6":
                setKeepAsking(false);
                System.out.println(ConsoleColors.changeAnsiBoldColor("¡Adios!", ConsoleColors.ANSI_CYAN) + ConsoleColors.changeAnsiBoldColor("\n¡Gracias por usar nuestro programa!", ConsoleColors.ANSI_BLUE));
                break;

            default:
                System.out.println(ConsoleColors.changeAnsiBoldColor("Opcion inválida", ConsoleColors.ANSI_RED));
                break;
        }
    }
}
