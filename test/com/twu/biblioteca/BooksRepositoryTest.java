import Library.Book;
import Library.BooksRepository;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BooksRepositoryTest {
    @Test
    public void testGetBooksName() throws Exception {
        BooksRepository booksRepository = new BooksRepository();
        booksRepository.repositoryInit();

        Map<String, Book> booksMap = booksRepository.getBooks();

        assertEquals(booksMap.get("000001").getName(), "Lean Thinking");
        assertEquals(booksMap.get("000002").getName(), "Clean Code");
    }
}
