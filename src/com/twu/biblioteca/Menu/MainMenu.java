package Menu;

import Console.*;

import java.util.Arrays;
import java.util.List;

public class MainMenu {
    private final Console console;
    private static List<String> options = Arrays.asList("List Books");

    private void print(String message) {
        console.print(message);
    }

    public MainMenu(Console console) {
        this.console = console;
    }

    public void showCurrentMenu() {
        print(this.getClass().toString());
    }

    public void showOptions() {
        print("[ L ] List Books\n");
    }
}
