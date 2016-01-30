import Library.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void testBookDetails() throws Exception {
        Book book = new Book("000001", "Lean Thinking", "James P. Womack", "2003-06-01");
        assertEquals("000001", book.getIsbn());
        assertEquals("Lean Thinking", book.getName());
        assertEquals("James P. Womack", book.getAuthor());
        assertEquals("2003-06-01", book.getPublishedDate());
    }

}
