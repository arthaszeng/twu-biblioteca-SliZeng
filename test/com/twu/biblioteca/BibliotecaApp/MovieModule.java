package BibliotecaApp;

import Biblioteca.BibliotecaApp;
import Console.Console;
import Menu.Menu.MainMenu;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
}
