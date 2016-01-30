import Console.Console;
import Menu.MainMenu;
import Menu.Option;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;
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

        verify(console).print("[ L ] List Books\t");
    }

    @Test
    public void testSelectOption() throws Exception {
        String symble = "l";
//        assertEquals("List Books", mainMenu.selectOption(symble.toUpperCase()));
        assertThat(mainMenu.selectOption(symble), isA(Option.class));

//        verify(console).print("<<Lean Thinking>>\tJames P. Womack\t2003-06-01\t000001\n");
//        verify(console).print("<<Clean Code>>\tJames P. Womack\t2003-06-01\t000002\n");
    }
}
