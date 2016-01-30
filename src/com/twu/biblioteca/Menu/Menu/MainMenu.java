package Menu.Menu;

import Console.Console;
import Format.MenuFormat;
import Menu.Option.CheckOutOption;
import Menu.Option.ErrorOption;
import Menu.Option.Option;
import Menu.Option.ListBooksOption;
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
        optionsMap.put("L", new ListBooksOption());
    }

    public void showCurrentMenu() {
        print(this.getClass().toString());
    }

    public void showOptions() {

        for (Object o : optionsMap.entrySet()) {
            Map.Entry s = (Map.Entry)o;
            Option option = (Option) s.getValue();
            print(MenuFormat.format((option.getName()) + "\t"));
        }
        System.out.println();
    }

    public Option selectOption(final String message) {
        String symble = message.toUpperCase();
        Option selectedOption;
        selectedOption = optionsMap.get(symble);
        return checkOption(selectedOption);
    }

    private Option checkOption(Option selectedOption) {
        return selectedOption == null ? new ErrorOption(console) : selectedOption;
    }


    public void addOption(CheckOutOption checkOutOption) {
        optionsMap.put(String.valueOf(checkOutOption.getName().charAt(0)).toUpperCase(), checkOutOption);
    }
}
