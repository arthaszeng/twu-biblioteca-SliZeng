import Biblioteca.BibliotecaApp;
import Console.Console;
import Menu.Menu.MainMenu;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Console console;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUpStreams() {
        console= mock(Console.class);
        MainMenu mainMenu = mock(MainMenu.class);
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
        Boolean flag1 = bibliotecaApp.checkout("000001");
        Boolean flag2 = bibliotecaApp.checkout("000002");

        bibliotecaApp.showAllBooks();

        assertTrue(flag1);
        assertTrue(flag2);
        verify(console, times(2)).print("Thank you! Enjoy the book.\n");
        verify(console, times(0)).print("Lean Thinking\n");
        verify(console, times(0)).print("Clean Code\n");
    }

    @Test
    public void testCheckoutBookFailed() throws Exception {
        Boolean flag1 = bibliotecaApp.checkout("wrong");
        Boolean flag2 = bibliotecaApp.checkout("98794");

        bibliotecaApp.showAllBooks();

        assertFalse(flag1);
        assertFalse(flag2);
        verify(console, times(0)).print("Thank you! Enjoy the book.\n");
        verify(console, times(2)).print("That book is not available\n");
        verify(console, times(1)).print("Lean Thinking\n");
        verify(console, times(1)).print("Clean Code\n");
    }

    @Test
    public void testReturnBookSuccessful() throws Exception {
        bibliotecaApp.checkout("000001");
        bibliotecaApp.checkout("000002");
        Boolean flag = bibliotecaApp.returnBook("000001");

        bibliotecaApp.showAllBooks();

        assertTrue(flag);
        verify(console).print("Thank you for returning the book\n");
        verify(console).print("Lean Thinking\n");
        verify(console, times(0)).print("Clean Code\n");
    }
}

