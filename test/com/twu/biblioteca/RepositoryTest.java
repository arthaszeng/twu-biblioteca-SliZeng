import Library.Book;
import Library.BooksRepository;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {
    @Test
    public void testGetBooksMap() throws Exception {
        BooksRepository booksRepository = new BooksRepository();

        Map<String, Book> booksMap = booksRepository.getBooks();

        assertEquals(booksMap.get("000001").getName(), "Lean Thinking");
        assertEquals(booksMap.get("000002").getName(), "Clean Code");
    }

    @Test
    public void testGetMoviesMap() throws Exception {

    }
}
