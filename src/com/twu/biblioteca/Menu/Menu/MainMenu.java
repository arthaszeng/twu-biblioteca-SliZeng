package Menu.Menu;

import Console.Console;
import Format.MenuFormat;
import Menu.Option.ErrorOption;
import Menu.Option.ListBooksOption;
import Menu.Option.ListMoviesOption;
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
        addOption(new ListBooksOption());
        addOption(new ListMoviesOption());
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

    public void addOption(Option option) {
        optionsMap.put(String.valueOf(option.getKey().toUpperCase()), option);
    }

}
