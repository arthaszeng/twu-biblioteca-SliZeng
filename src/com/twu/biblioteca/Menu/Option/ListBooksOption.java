package Menu.Option;

import Biblioteca.BibliotecaApp;

public class ListBooksOption extends Option {
    public ListBooksOption() {
        this.name = "List Books";
        this.key = "b";
    }

    @Override
    public boolean operate(BibliotecaApp bibliotecaApp) {
        bibliotecaApp.showAllBooksDetails();
        return true;
    }
}

