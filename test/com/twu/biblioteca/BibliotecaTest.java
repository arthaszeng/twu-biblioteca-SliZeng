import Biblioteca.BibliotecaApp;
import Console.Console;
import Menu.Menu.MainMenu;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

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

    @Test
    public void testCheckoutBookSuccessful() throws Exception {
        bibliotecaApp.checkout("000001");
        bibliotecaApp.checkout("000002");
        bibliotecaApp.showAllBooks();

        verify(console, times(2)).print("Thank you! Enjoy the book.\n");
        verify(console, times(0)).print("Lean Thinking\n");
        verify(console, times(0)).print("Clean Code\n");
    }

    @Test
    public void testCheckoutBookFailed() throws Exception {
        bibliotecaApp.checkout("wrong");
        bibliotecaApp.checkout("98794");
        bibliotecaApp.showAllBooks();

        verify(console, times(0)).print("Thank you! Enjoy the book.\n");
        verify(console, times(2)).print("That book is not available\n");
        verify(console, times(1)).print("Lean Thinking\n");
        verify(console, times(1)).print("Clean Code\n");
    }

}

