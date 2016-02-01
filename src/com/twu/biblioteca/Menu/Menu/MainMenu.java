package Menu.Menu;

import Console.Console;
import Format.MenuFormat;
import Menu.Option.ErrorOption;
import Menu.Option.ListBooksOption;
import Menu.Option.Option;

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
        optionsMap.put("B", new ListBooksOption());
    }

    public void showCurrentMenu() {
        print(this.getClass().toString());
    }

    public void showOptions() {

        for (Object o : optionsMap.entrySet()) {
            Map.Entry s = (Map.Entry)o;
            Option option = (Option) s.getValue();
            print(MenuFormat.format(option) + "\t");
        }
        System.out.println();
    }

    public Option selectOption(final String message) {
        String key = message.toUpperCase();
        Option selectedOption;
        selectedOption = optionsMap.get(key);
        return selectedOption == null ? new ErrorOption(console) : selectedOption;
    }

//    private Option checkOption(Option selectedOption) {
//        return selectedOption == null ? new ErrorOption(console) : selectedOption;
//    }

    public void addOption(Option option) {
        optionsMap.put(String.valueOf(option.getKey().toUpperCase()), option);
    }

}
