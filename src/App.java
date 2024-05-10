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
