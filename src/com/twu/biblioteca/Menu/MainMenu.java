package Menu;

import Console.*;

public class MainMenu {
    private final Console console;

    private void print(String message) {
        console.print(message);
    }

    public MainMenu(Console console) {
        this.console = console;
    }

    public void showCurrentMenu() {
        print(this.getClass().toString());
    }
}
