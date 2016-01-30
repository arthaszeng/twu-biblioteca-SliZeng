import Console.Console;
import Format.MenuFormat;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class FormatTest {
    private MenuFormat menuFormat;
    private Console console;

    @Before
    public void setUp() throws Exception {
        console = mock(Console.class);
        menuFormat = new MenuFormat(console);
    }

    @Test
    public void testMenuFormat() throws Exception {

        assertEquals("[ L ] List Books", menuFormat.format("List Books"));
    }
}
