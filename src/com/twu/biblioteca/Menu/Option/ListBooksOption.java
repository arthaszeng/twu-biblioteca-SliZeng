package Menu.Option;

import Biblioteca.BibliotecaApp;

public class ListBooksOption extends Option {
    public ListBooksOption() {
        this.name = "List Books";
    }

    @Override
    public void operate(BibliotecaApp bibliotecaApp) {
        bibliotecaApp.showAllBooksDetails();
    }
}

