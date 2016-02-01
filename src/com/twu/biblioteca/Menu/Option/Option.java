package Menu.Option;

import Biblioteca.BibliotecaApp;

public class Option {
    protected String name;
    protected String key;

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public boolean operate(BibliotecaApp bibliotecaApp) {
        return true;
    }

}
