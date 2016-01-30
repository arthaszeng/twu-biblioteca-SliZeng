import Menu.MainMenu;
import Console.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class MenuTest {
    private Console console;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUpStreams() {
        console= mock(Console.class);
        bibliotecaApp = new BibliotecaApp(console, new MainMenu(console));
    }


    @Test
    public void testShowMenu() throws Exception {

    }
}
