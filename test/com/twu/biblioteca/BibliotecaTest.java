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
        verify(console).print("Clean Code\n");
    }

    @Test
    public void testShowAllBooksDetails() throws Exception {
        bibliotecaApp.showAllBooksDetails();

        verify(console).print("<<Lean Thinking>>\tJames P. Womack\t2003-06-01\t000001\n");
        verify(console).print("<<Clean Code>>\tJames P. Womack\t2003-06-01\t000002\n");
    }
}

