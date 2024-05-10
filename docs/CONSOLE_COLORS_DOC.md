# ¡Bienvenido al código fuente de la clase ConsoleColors!

En este documento observarás el codigo detrás con sus explicaciones de esta clase :)

# Código de la clase

```
package net.quadrilingo.decorationstuff;


public class ConsoleColors {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";
    public static final String ANSI_ORANGE = "\u001B[38;5;208m";

    public static String changeAnsiColor(String message, String color) {
        return color + message + ANSI_RESET;
    }

    public static String changeAnsiBoldColor(String message, String color) {
        return BOLD + color + message + ANSI_RESET;
    }
}

```

## Atributos

- ANSI_RESET
  > Se encargará de volver a la normalidad el color de la consola

- BOLD
  > Se encargará de aumentar el grosor de una cadena de texto

- ANSI_(RED,GREEN,YELLOW,BLUE,CYAN,ORANGE)
  > Se encargarán de cambiar el color de la consola.

## Método changeAnsiColor

Este método se encargará de devolver una cadena de texto a un color especificado

Recibe 2 parámetros:

- **message**
  > Cadena de texto a cambiar de color

- **color**
  > Color a cambiar el mensaje

## Método changeAnsiBoldColor

Recibe y hace lo mismo que el método **changeAnsiColor**, solo que añade el grosor al mensaje de texto.