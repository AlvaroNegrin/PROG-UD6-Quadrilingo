# ¡Bienvenido al código fuente de la clase Dictionary!

En este documento podrás ver como funciona esta clase a total detalle.

# Código de la clase

```

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

            if (dictionary.get(wordFirstLetter).contains(wordFormatted)) {
                dictionary.get(wordFirstLetter).remove(wordFormatted);

                System.out.println(ConsoleColors.changeAnsiBoldColor("Su palabra " + ConsoleColors.ANSI_ORANGE + wordFormatted +
                ConsoleColors.ANSI_GREEN +
                " se ha eliminado correctamente", ConsoleColors.ANSI_GREEN));
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
            System.out.println(ConsoleColors.changeAnsiBoldColor("No hay ninguna inicial que contenga palabras",
            ConsoleColors.ANSI_ORANGE));
        } else {
            System.out.println(ConsoleColors.changeAnsiColor("Estas son las iniciales que contienen alguna palabra:",
            ConsoleColors.ANSI_GREEN));
            System.out.println(initialsWithInfo);
        }
    }

    public void showWordsByInitial(String letter) {
        String letterFormatted = this.formatText(letter);
        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(letterFormatted)) {
                if (entry.getValue().isEmpty()) {
                    System.out.println(ConsoleColors.changeAnsiBoldColor("Lo siento maquina, esta vacia la lista ;)",
                    ConsoleColors.ANSI_YELLOW));
                } else {
                    System.out.println(ConsoleColors.changeAnsiColor("Lista de la letra " + ConsoleColors.ANSI_RED
                    + letterFormatted + ConsoleColors.ANSI_YELLOW + ":\n", ConsoleColors.ANSI_YELLOW) + entry.getValue());
                }
            } else if (letter.length() == 0 || letter.length() > 1 {
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

```

# Atributos

- **letter**
> Este atributo guardará todas las claves del diccionario. Es decir (a,b,c...)

- **dictionary**
> Este atributo será el eje principal del programa, ya que será el que guardará llaves y valores debido a ser un Map.

# Constructor

El constructor de este programa, estará inicializando nuestro dictionario con todas las letras del abecedario inglés, las cuales serán las llaves, y cada una con un propio **HashSet**, para que puedan tener sus propias listas de palabras guardadas sin repetición alguna.

# Método addWord

Este método se encargará de añadir una palabra pasada como parámetro al diccionario.

- Si la palabra indicada no contiene ningun número o no esta vacía, se procederá a utilizar el método **formatText** para tener una palabra formateada, luego utilizando otra variable que guardará el primer carácter de la palabra formateada. Para luego pasarla como parámetro para saber si la llave que esta almacenada en el diccionario es igual a la primera letra.
> [!NOTE]
> Si esa llave es igual a la primera letra pasada como parámetro, entonces se procederá a añadirse en la lista de valores de esa llave la palabra y finalizando con un mensaje de validación bonito :).

- En caso contrario de que la palabra contenga algún numero o este vacía, aparecerá un mensaje de error y no se añadirá la palabra al diccionario.

# Método deleteWord

Este método se encargará de eliminar una palabra existente diccionario pasada como parámetro.

- Si la palabra indicada no contiene ningún número o no esta vacía, se procederá a realizar la misma accion para formatear y guardar el primer caracter como lo es con el método **addword**.

> [!NOTE]
> Si esa llave es igual a la primera letra pasada y que contiene el valor de la palabra formateada, entonces se procederá a eliminar el valor almacenado en esa llave para luego mostrar un mensaje de validación bonito :).

- En caso de que la palabra contenga algún nùmero o este vacía, se mostrará un mensaje de error y no se eliminará ninguna palabra.

# Método showWordIfExists

Este método se encargará de comprobar si la palabra que buscamos existe o no en el diccionario.

> [!NOTE]
> Se realizará el mismo proceso de comprobación que en los métodos **addWord** y **deleteWord**, para comprobar si la palabra contiene algún numero o esta vacía.
> Además se realizará la misma manera de formatear y guardar el primer carácter de la palabra.

## Return

Este método retornará mediante una ternaria comprobando si la llave es igual al primer carácter de la palabra y si la llave contiene esa palabra como valor.
> [!NOTE]
> Esta método utiliza la misma forma de comprobar si la palabra esta vacía o si contiene algun numero que los métodos anteriores.
- Si la contiene, se retornará un mensaje con una cadena de texto indicando que esa palabra existe
- Caso contrario, retornara un mensaje diciendo que no existe.
- En caso que la palabra este vacia o contenga algún número, mostrará un mensaje de error

# Método showInitialsWithInfo

Este método se encargará de mostrar una lista de todas las llaves que contengan algun valor almacenado, en este caso serían todas las iniciales del abecedario que contengan información.
Junto con un bucle for, utilizando un **entrySet()** el cual nos permitirá interactuar con los valores o llaves en forma de iteración.

- Si almenos alguna llave del mapa tiene un valor, se procederá con el bucle para ir almacenando las lllaves en una variable local, para despues con una condicional dependiendo del estado de la variable local nos muestre la lista de las iniciales con valores.
- Caso contrario, de que no haya ninguna sola llave con información, directamente se mostrará un mensaje indicando el error.

# Método showWordsByInitial

Este método se encargará de mostrar una lista de todas las palabras que empiecen por la letra especificada por el usuario.

- Si no hay ninguna llave que contenga palabras aún, saltará un mensaje de error indicando que no hay ninguna palabra almacenada.
- Si se pasa mas de una letra o si esta vacía la información, saltará un mensaje de error.
- Si hay información en alguna llave y es la misma pasada como parámetro, se procederá a mostrar toda la información de la misma.

# Método formatText

Este método es el encargado de formatear a **lowerCamelCase** y quitando todos los espacios encontrados a la palabra pasada como parámetro.

# Método containsNumber

Este método es el encargado mediante un bucle for que recorrerá hasta que sea menor a la longitud de la palabra utilizando un método estático de la clase **Character**

- Si hay algun número en la palabra, este método retornará un **true**
- Caso contrario devolverá un **false**