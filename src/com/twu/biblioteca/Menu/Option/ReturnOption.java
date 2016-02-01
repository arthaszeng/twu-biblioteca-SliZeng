package Menu.Option;

import Biblioteca.BibliotecaApp;
import Console.Console;

public class ReturnOption extends Option{
    private Console console;
    public ReturnOption() {
        this.key = "R";
        this.name = "Return books or movies";
        console = new Console();
    }

    @Override
    public boolean operate(BibliotecaApp bibliotecaApp) {
        if (bibliotecaApp.isLogined()) {
            bibliotecaApp.returnBook(console.scaner());
            return true;
        }else {
            return false;
        }
    }
}
