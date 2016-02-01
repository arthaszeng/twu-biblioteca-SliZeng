package Menu.Option;

import Biblioteca.BibliotecaApp;

import java.util.Scanner;

public class CheckOutOption extends Option{
    public CheckOutOption() {
        this.name = "Check out";
        this.key = "c";
    }

    @Override
    public boolean operate(BibliotecaApp bibliotecaApp) {
        if (!bibliotecaApp.isLogined()){
            return false;
        }else {
            System.out.println("Please input the ISBN or IMDB");
            Scanner scanner = new Scanner(System.in);
            String isbn = scanner.next();
            bibliotecaApp.checkout(isbn);
            return true;
        }
    }
}
