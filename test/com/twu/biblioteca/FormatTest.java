import Format.BookFormat;
import Format.MenuFormat;
import Format.MovieFormat;
import Library.Book;
import Library.Movie;
import Menu.Option.ListBooksOption;
import Menu.Option.Option;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatTest {

    @Test
    public void testMenuFormat() throws Exception {
        Option option = new ListBooksOption();
        assertEquals("[ B ] List Books", MenuFormat.format(option));
    }

    @Test
    public void testBookDetailsFormat() throws Exception {
        Book book = new Book("000001", "Lean Thinking", "James P. Womack", "2003-06-01");
        assertEquals("<<Lean Thinking>>\tJames P. Womack\t2003-06-01\t000001", BookFormat.format(book));

    }

    @Test
    public void testMovieFormat() throws Exception {
        Movie movie = new Movie("tt1187043", "3 idiots", "2009", "Rajkumar Hirani", "9.1");
        assertEquals("<<3 idiots>>\t2009\tRajkumar Hirani\t9.1\ttt1187043", MovieFormat.format(movie));
    }
}
