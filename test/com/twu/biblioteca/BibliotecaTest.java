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
        mainMenu = mock(MainMenu.class);
        bibliotecaApp = new BibliotecaApp(console, mainMenu);
    }

    @Test
    public void testShowAllBooksName() throws Exception {
        bibliotecaApp.showAllBooks();

        verify(console).print("Lean Thinking\n");
    }
}

