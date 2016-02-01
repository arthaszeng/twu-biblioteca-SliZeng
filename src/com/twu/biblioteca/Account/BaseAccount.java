package Account;

import Library.Book;
import Library.Movie;

import java.util.HashMap;
import java.util.Map;

public class BaseAccount {
    private String name;
    private final String email;
    private String phoneNumber;
    private String password;
    private String role = "user";
    private static Map<String, Book> checkedBooksMap = new HashMap<String, Book>();
    private static Map<String, Movie> checkedMoviesMap = new HashMap<String, Movie>();


    public BaseAccount(String name, String email, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void checkoutBooks(Book book) {
        checkedBooksMap.put(book.getIsbn(), book);
    }

    public void checkoutMovies(Movie movie) {
        checkedMoviesMap.put(movie.getImdb(), movie);
    }
}
