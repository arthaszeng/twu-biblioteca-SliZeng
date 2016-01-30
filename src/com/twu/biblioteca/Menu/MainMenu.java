package Menu;

import Console.*;
import Format.MenuFormat;

import java.util.Arrays;
import java.util.Iterator;
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
        for (Iterator i = options.iterator(); i.hasNext();) {
            print(MenuFormat.format(i.next().toString()) + "\t");
        }
        System.out.println();
    }
}
