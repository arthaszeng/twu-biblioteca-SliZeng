package Format;

import Library.Movie;

public class MovieFormat {
    public static String format(Movie movie) {
        return movie.getClass().equals(null) ? "That is a invalid movie." : String.format("<<%s>>\t%s\t%s\t%s\t%s\n",
                movie.getName(), movie.getPublishedYear(),
                movie.getDirector(), movie.getRating(), movie.getImdb());
    }
}
