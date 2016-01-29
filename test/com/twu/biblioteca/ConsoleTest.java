import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsoleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Console console;
    private BibliotecaApp bibliotecaApp;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        console= mock(Console.class);
        bibliotecaApp = new BibliotecaApp(console);
    }

    @Test
    public void testPrint() throws Exception {
        Console console = new Console();
        console.print("Welcome");

        assertEquals("Welcome", outContent.toString());
    }

    @Test
    public void testPrintln() throws Exception {
        Console console = new Console();
        console.println("Welcome");

        assertEquals("Welcome\n", outContent.toString());
    }

    @Test
    public void testShowWelcome() throws Exception {
        bibliotecaApp.showWelcome();

        verify(console).print("Welcome\n");
    }
}
