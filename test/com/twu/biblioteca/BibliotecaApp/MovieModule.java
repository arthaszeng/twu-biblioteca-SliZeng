package BibliotecaApp;

import Biblioteca.BibliotecaApp;
import Console.Console;
import Menu.Menu.MainMenu;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class MovieModule {

    private Console console;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUpStreams() {
        console= mock(Console.class);
        MainMenu mainMenu = mock(MainMenu.class);
        bibliotecaApp = new BibliotecaApp(console, mainMenu);
    }

    @Test
    public void testShowAllMoviesName() throws Exception {
        bibliotecaApp.showAllMovies();

        verify(console).print("3 idiots\n");
        verify(console).print("Peekay\n");
    }

    @Test
    public void testShowAllMoviesDetails() throws Exception {
        bibliotecaApp.showAllMOviesDetails();

        verify(console).print("<<3 idiots>>\t2009\tRajkumar Hirani\t9.1\ttt1187043\n");
        verify(console).print("<<Peekay>>\t2014\tRajkumar Hirani\t8.3\ttt2338151\n");
    }

    @Test
    public void testCheckoutMovieSuccessful() throws Exception {
        Boolean flag1 = bibliotecaApp.checkout("tt1187043");
        Boolean flag2 = bibliotecaApp.checkout("tt2338151");

        bibliotecaApp.showAllMovies();

        assertTrue(flag1);
        assertTrue(flag2);
        verify(console, times(2)).print("Thank you! Enjoy the movie.\n");
        verify(console, times(0)).print("3 idiots\n");
        verify(console, times(0)).print("Peekay\n");
    }

    @Test
    public void testCheckoutMovieFailed() throws Exception {
        Boolean flag1 = bibliotecaApp.checkout("wrong");
        Boolean flag2 = bibliotecaApp.checkout("98794");

        bibliotecaApp.showAllMovies();

        assertFalse(flag1);
        assertFalse(flag2);
        verify(console, times(0)).print("Thank you! Enjoy the movie.\n");
        verify(console, times(2)).print("That is not available\n");
        verify(console, times(1)).print("3 idiots\n");
        verify(console, times(1)).print("Peekay\n");
    }


}
