package Format;

import Library.Book;

public class BookFormat {
    public static String detailsFormat(Book book) {
        return String.format("<<%s>>\t%s\t%s\t%s", book.getName(), book.getAuthor(), book.getPublishedDate(), book.getIsbn());
    }
}
