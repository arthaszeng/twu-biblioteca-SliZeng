package Menu.Option;

import Biblioteca.BibliotecaApp;

import java.util.Scanner;

public class CheckOutOption extends Option{
    public CheckOutOption() {
        this.name = "Check out";
    }

    @Override
    public void operate(BibliotecaApp bibliotecaApp) {
        System.out.println("Please input the ISBN");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.next();
        bibliotecaApp.checkout(isbn);
    }
}
