import Library.Book;
import Library.BooksRepository;
import Library.Movie;
import Library.MoviesRepository;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {
    @Test
    public void testGetBooksMap() throws Exception {
        BooksRepository booksRepository = new BooksRepository();

        Map<String, Book> booksMap = booksRepository.getMaps();

        assertEquals(booksMap.get("000001").getName(), "Lean Thinking");
        assertEquals(booksMap.get("000002").getName(), "Clean Code");
    }

    @Test
    public void testGetMoviesMap() throws Exception {
        MoviesRepository moviesRepository = new MoviesRepository();

        Map<String, Movie> moviesMap = moviesRepository.getMap();
        Movie moive = moviesMap.get("tt1187043");
        assertEquals(moive.getName(), "3 idiots");
        assertEquals(moive.getImdb(), "tt1187043");
        assertEquals(moive.getPublishedYear(), "2009");
        assertEquals(moive.getDirector(), "Rajkumar Hirani");
        assertEquals(moive.getRating(), "9.1");
    }
}
