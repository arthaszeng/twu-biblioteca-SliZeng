import Format.MenuFormat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatTest {

    @Test
    public void testMenuFormat() throws Exception {
        assertEquals("[ L ] List Book", MenuFormat.format("List Book"));
    }


}
