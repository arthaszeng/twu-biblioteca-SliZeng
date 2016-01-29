import Menu.MainMenu;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class MenuTest {
    private Console console;
    private BibliotecaApp bibliotecaApp;
    private MainMenu mainMenu;

    @Before
    public void setUpStreams() {
        console= mock(Console.class);
        mainMenu = new MainMenu();
        bibliotecaApp = new BibliotecaApp(console, mainMenu);
    }


    @Test
    public void testShowMenu() throws Exception {

    }
}
