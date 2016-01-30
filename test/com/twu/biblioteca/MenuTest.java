import Biblioteca.BibliotecaApp;
import Console.Console;
import Menu.MainMenu;
import Menu.Option;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertEquals;
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
        assertThat(mainMenu.selectOption("l"), isA(Option.class));

        assertEquals(mainMenu.selectOption("l").getName(), "List Books");
    }

    @Test
    public void testInvalidOption() throws Exception {

        assertThat(mainMenu.selectOption("a"), is(Null.NULL));

        verify(console).print("Selected an invalid option. Please re-enter\n");
    }

    @Test
    public void testOperate() throws Exception {
        Option option = mainMenu.selectOption("l");
        option.operate(bibliotecaApp);
        verify(console).print("<<Lean Thinking>>\tJames P. Womack\t2003-06-01\t000001\n");
        verify(console).print("<<Clean Code>>\tJames P. Womack\t2003-06-01\t000002\n");
    }
}
