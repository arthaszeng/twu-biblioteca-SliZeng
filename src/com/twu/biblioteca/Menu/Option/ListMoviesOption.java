package Menu.Option;

import Biblioteca.BibliotecaApp;

public class ListMoviesOption extends Option {
    public ListMoviesOption() {
        this.key = "M";
        this.name = "List movies";
    }

    @Override
    public boolean operate(BibliotecaApp bibliotecaApp) {
        bibliotecaApp.showAllMOviesDetails();
        return true;
    }
}
