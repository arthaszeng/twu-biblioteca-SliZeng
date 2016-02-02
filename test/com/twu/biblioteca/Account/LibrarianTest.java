package Account;

import Biblioteca.BibliotecaApp;
import Console.Console;
import Menu.Menu.MainMenu;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LibrarianTest {


    @Test
    public void testShowOperationLog() throws Exception {
        Console console = mock (Console.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console, new MainMenu(console));

        when(console.scaner()).thenReturn("admin");
        BaseAccount librarian = bibliotecaApp.accountSystem.login(bibliotecaApp);

        boolean levelUpFlag = bibliotecaApp.accountSystem.levelUp(librarian);
        bibliotecaApp.checkout("000001");

        verify(console,times(4)).print(anyString());
        boolean showFlag = bibliotecaApp.showOperationLog();
        verify(console,times(5)).print(anyString());

        assertTrue(levelUpFlag);
        assertTrue(showFlag);
        assertEquals(librarian.getRole(), "librarian");
    }


}
