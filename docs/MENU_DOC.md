# ¡Bienvenido al código fuente de la clase Menú!

En este documento podras observar como funciona la clase a detalle

# Código de la clase

```
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

```

# Atributos

- keepAsking
> Servirá como condición para poder seguir mostrando el menú
- dictionary
> Instancia de la clase Dictionary, donde gracias a este atributo, podremos llamar a sus métodos en el menú
- SC
> Servirá para las entradas de usuario por consola.

# Métodos de acceso

Se han realizado el **getter** y **setter** para el atributo **keepAsking**

# Método showMainMenu

Este método realizará la impresión del menú principal por consola, utiliznado 2 variables locales para usarlas como argumentos de los métodos **changeAnsiColor/changeAnsiBoldColor** de la clase **ConsoleColors**.
Mostrando un menú como el siguiente:

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/934d7271-b450-4ae8-a8a8-abc556773c84)


# Método optionsMenu

Este método será el encargado de realizar ciertas operaciónes dependiendo de la opción que escoja el usuario del 1-6 mediante un switch.

## **Caso 1: se realizará la operación para añadir una palabra.**

- Si la palabra es válida

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/1596ebca-bb9f-4575-891a-445e10ecfde5)


## **Caso 2: se realizará la operación para eliminar una palabra**

- Si la palabra introducida es válida y existe

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/21c4c52b-fecc-40cc-942e-c1b45b867095)

- Si coloca una palabra válida pero que no existe en el diccionario

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/16393d8c-a48f-4fbc-bfb8-fb92d6bb581f)


## Caso 3: se realizará la operacion de si existe la palabra en el diccioanario

- Si la palabra es válida y existe en el diccionario

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/44b52bdc-9b00-4392-bb2e-0df35d7e0721)

- Si la palabrá es válida pero no existe en el diccionario

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/1db51fd2-e01d-468f-884e-6acf4f02d4b3)

## Caso 4: se realizará la operación de mostrar una lista de todas las llaves que contengan valores

- Si hay valores en almenos una llave, se muestra lo siguiente

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/c7f40b97-30ab-4250-a24f-7c786a9ee141)

- Si ninguna llave tiene almenos un dato

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/3ea3525e-38cf-496f-bdf8-e4f816d21c92)

## Caso 5: se realizará la operacion de mostrar de ver palabras por inicial.

- Si hay información almacenada en la letra especificada

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/3ca054ec-c2b0-421f-bec6-8a9b087a5c32)

- Si no hay información almacenada en la letra especificada

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/ae99fa20-7144-4c96-89ee-46e2081b5876)

- Si se introduce mas de 1 letra

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/6791db46-bafc-4ac8-a145-90979dab8da1)

## Case 6: se realizará la operación de cerrar el programa

Se mostrará el siguiente mensaje:

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/2f362a56-990a-409d-b66a-6819cc5e85e7)


## Caso especial

- Si el usuario en cualquiera de las opciones que requieran entrada de datos de solo textos, coloca una información vacía o introduzca un número en cualquier parte del dato, mostrará un mensaje de error.

- Información vacía

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/452b8e02-e098-4e4d-b3b8-47c9491c1708)

- Información con números

![image](https://github.com/AlvaroNegrin/PROG-UD6-Quadrilingo/assets/159430287/2eb7f8cf-51b3-46c1-8526-45f9a8b35fab)
