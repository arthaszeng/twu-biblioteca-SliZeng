package Menu.Option;

import Biblioteca.BibliotecaApp;
import Console.Console;

import java.util.Scanner;

public class CheckOutOption extends Option{
    private Console console;
    public CheckOutOption(Console console) {
        this.name = "Check out";
        this.console = console;
    }

    @Override
    public void operate(BibliotecaApp bibliotecaApp) {
        System.out.println("Please input the ISBN");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.next();
        bibliotecaApp.checkout(isbn);
    }
}
