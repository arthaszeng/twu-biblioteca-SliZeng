import Menu.MainMenu;
import Console.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {
    private Console console;
    private BibliotecaApp bibliotecaApp;
    private MainMenu mainMenu;

    @Before
    public void setUpStreams() {
        console= mock(Console.class);
        mainMenu = new MainMenu(console);
        bibliotecaApp = new BibliotecaApp(console, new MainMenu(console));
    }

    @Test
    public void testShowCurrentMenu() throws Exception {
        mainMenu.showCurrentMenu();

        verify(console).print(mainMenu.getClass().toString());
    }

    @Test
    public void testShowOptions() throws Exception {
        mainMenu.showOptions();

        verify(console).print("[ L ] List Book\t");
    }
}
