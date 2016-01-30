import Library.Book;
import Library.BooksRepository;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BooksRepositoryTest {
    @Test
    public void testGetBooks() throws Exception {
        BooksRepository booksRepository = new BooksRepository();
        booksRepository.repositoryInit();
        Map<String, Book> booksMap = booksRepository.getBooks();
        assertEquals(booksMap.get("000001").getName(), "Lean Thinking");
    }
}
