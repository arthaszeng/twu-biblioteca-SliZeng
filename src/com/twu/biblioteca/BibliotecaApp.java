public class BibliotecaApp {
    private final Console console;

    public BibliotecaApp(Console console) {
        this.console = console;
    }

    public void showWelcome(){
        console.print("Welcome\n");
    }
}
