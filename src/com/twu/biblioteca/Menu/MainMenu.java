package Menu;

import Console.Console;
import Format.MenuFormat;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {
    private final Console console;
    private static Map<String, Option> optionsMap = new HashMap<String, Option>();

    private void print(String message) {
        console.print(message);
    }

    public MainMenu(Console console) {
        this.console = console;
        optionsMap.put("L", new Option("List Books"));
    }

    public void showCurrentMenu() {
        print(this.getClass().toString());
    }

    public void showOptions() {

        for (Object o : optionsMap.entrySet()) {
            Map.Entry s = (Map.Entry)o;
            Option option = (Option) s.getValue();
            print(MenuFormat.format((option.name) + "\t"));
        }
        System.out.println();
    }

    public Option selectOption(final String message) {
        String symble = message.toUpperCase();
        Option selectedOption;
        selectedOption = optionsMap.get(symble);
        return selectedOption;
    }
}
