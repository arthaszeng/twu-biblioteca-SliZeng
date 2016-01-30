import Console.Console;
import Format.MenuFormat;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        menuFormat.format("List Books");

        verify(console).print("[ L ] List Books");
    }
}
