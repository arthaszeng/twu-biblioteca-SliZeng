import Console.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Console console;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
//        System.setIn(inConten);
        console = new Console();
    }

    @Test
    public void testPrint() throws Exception {
        console.print("Welcome");

        assertEquals("Welcome", outContent.toString());
    }

    @Test
    public void testPrintln() throws Exception {
        console.println("Welcome");

        assertEquals("Welcome\n", outContent.toString());
    }

    @Test
    public void testShowWelcome() throws Exception {
         console.showWelcome();

        assertEquals("Welcome\n", outContent.toString());
    }


}
