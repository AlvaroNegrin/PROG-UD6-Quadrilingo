# ¡Bienvenido al código fuente de la clase Main!

En este documento sabrás el gran código complicado que esta en la clase ejecutable de nuestro programa :)

# Código de la clase

```
import net.quadrilingo.menu.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Menu.setKeepAsking(true);
        while (Menu.isKeepAsking()) {
            Menu.showMainMenu();
            Menu.optionMenu();
        }
    }
}

```

Como verás en esta complicadísima y super extensa clase ejecutable, es la que se encargará como lo dice su nombre de ejecutar el programa principal del pájaro cortador de procastinadores llamado Duolingo.
Se utiliza el método estático **setKeepAsking** de la clase **Menu** para usarlo como condición del bucle que hará que repita el menú principal del programa con sus opciones.