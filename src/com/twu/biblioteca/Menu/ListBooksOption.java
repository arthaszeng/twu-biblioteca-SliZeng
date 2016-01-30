package Menu;

import Biblioteca.BibliotecaApp;

public class ListBooksOption extends Option {

    public ListBooksOption(String name) {
        super(name);
    }

    @Override
    public void operate(BibliotecaApp bibliotecaApp) {
        bibliotecaApp.showAllBooksDetails();
    }
}
