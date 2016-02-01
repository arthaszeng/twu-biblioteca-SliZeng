package Menu.Option;

import Biblioteca.BibliotecaApp;

public class ListBooksOption extends Option {
    public ListBooksOption() {
        this.name = "List Books";
        this.key = "b";
    }

    @Override
    public void operate(BibliotecaApp bibliotecaApp) {
        bibliotecaApp.showAllBooksDetails();
    }
}

