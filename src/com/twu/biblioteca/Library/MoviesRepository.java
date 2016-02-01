package Library;

import java.util.LinkedHashMap;

public class MoviesRepository {
    private static LinkedHashMap<String, Movie> booksMap = new LinkedHashMap<String, Movie>();

    public MoviesRepository () {
        booksMap.put("tt1187043", new Movie("tt1187043", "3 idiots", "2009", "Rajkumar Hirani", "9.1"));
        booksMap.put("tt2338151", new Movie("tt2338151", "Peekay", "2014", "Rajkumar Hirani", "8.3"));
    }

    public LinkedHashMap<String,Movie> getMap() {
        return booksMap;
    }
}
