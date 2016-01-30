import Console.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
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
}
