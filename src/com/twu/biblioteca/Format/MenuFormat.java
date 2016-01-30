package Format;

import Console.Console;

public class MenuFormat {
    private final Console console;

    public MenuFormat(Console console) {
        this.console = console;
    }

    public void format(String message) {
        String buffer = String.format("[ %c ] %s", message.charAt(0), message);
        console.print(buffer);
    }
}
