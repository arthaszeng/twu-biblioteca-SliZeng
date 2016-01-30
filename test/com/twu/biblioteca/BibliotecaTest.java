import Console.Console;
import Menu.MainMenu;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    private Console console;
    private BibliotecaApp bibliotecaApp;
    private MainMenu mainMenu;

    @Before
    public void setUpStreams() {
        console= mock(Console.class);
        bibliotecaApp = new BibliotecaApp(console,new MainMenu(console));
    }


    @Test
    public void testShowWelcome() throws Exception {
        bibliotecaApp.showWelcome();

        verify(console).print("Welcome\n");
    }


}

