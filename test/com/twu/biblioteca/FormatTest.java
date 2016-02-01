import Format.BookFormat;
import Format.MenuFormat;
import Library.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatTest {

    @Test
    public void testMenuFormat() throws Exception {
        assertEquals("[ L ] List Book", MenuFormat.format("List Book"));
    }

    @Test
    public void testBookDetailsFormat() throws Exception {
        Book book = new Book("000001", "Lean Thinking", "James P. Womack", "2003-06-01");
        assertEquals("<<Lean Thinking>>\tJames P. Womack\t2003-06-01\t000001", BookFormat.format(book));

    }
}
