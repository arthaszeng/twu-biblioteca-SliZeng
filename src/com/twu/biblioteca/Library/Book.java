package Library;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private String publishedDate;

    public Book(String isbn, String name, String author, String publishedDate) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }
}
