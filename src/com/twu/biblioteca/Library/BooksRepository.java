package Library;

import java.util.LinkedHashMap;

public class BooksRepository {
    private static LinkedHashMap<String, Book> booksMap = new LinkedHashMap<String, Book>();

    public BooksRepository () {
        booksMap.put("000001", new Book("000001", "Lean Thinking", "James P. Womack", "2003-06-01"));
        booksMap.put("000002", new Book("000002", "Clean Code", "James P. Womack", "2003-06-01"));
    }

    public LinkedHashMap<String,Book> getBooks() {
        return booksMap;
    }
}
