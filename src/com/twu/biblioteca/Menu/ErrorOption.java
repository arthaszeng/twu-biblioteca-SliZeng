package Menu;

import Biblioteca.BibliotecaApp;
import Console.Console;

import java.util.Scanner;

public class ErrorOption extends Option {
    private Console console;

    public ErrorOption(Console console) {
        this.name = "ErrorOption";
        this.console = console;
    }

    @Override
    public void operate(BibliotecaApp bibliotecaApp) {
        Scanner scanner = new Scanner(System.in);

        console.print("Selected an invalid option. Please re-enter\n");
        String buf = scanner.next();

        Option option = bibliotecaApp.menu.selectOption(String.valueOf(buf));
        option.operate(bibliotecaApp);
    }
}
