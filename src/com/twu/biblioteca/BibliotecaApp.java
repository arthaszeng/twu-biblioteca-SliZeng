import Menu.MainMenu;

public class BibliotecaApp {
    private final Console console;
    public MainMenu menu;

    public BibliotecaApp(Console console, MainMenu mainMenu) {
        this.console = console;
        this.menu = mainMenu;
    }

    public void showWelcome(){
        console.print("Welcome\n");
    }


}
