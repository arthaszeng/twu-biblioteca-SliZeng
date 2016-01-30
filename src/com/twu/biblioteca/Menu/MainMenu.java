package Menu;

import Console.*;
import Format.MenuFormat;

import java.util.*;

public class MainMenu {
    private final Console console;
    private static Map<String, String> optionsMap = new HashMap<String, String>();

    private void print(String message) {
        console.print(message);
    }

    public MainMenu(Console console) {
        this.console = console;
        optionsMap.put("L", "List Books");
    }

    public void showCurrentMenu() {
        print(this.getClass().toString());
    }

    public void showOptions() {

        for (Object o : optionsMap.entrySet()) {
            print(MenuFormat.format(((Map.Entry) o).getValue().toString()) + "\t");
        }
        System.out.println();
    }

    public String selectOption(final String message) {
        String symble = message.toUpperCase();

    }
}
