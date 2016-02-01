package Format;

import Account.BaseAccount;
import Library.Book;
import Library.Movie;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormat {
    public static String format(BaseAccount account, Book book) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return String.format("%s checked %s,%s\n", account.getEmail(), book.getIsbn(), dateFormat.format(date));
    }

    public static String format(BaseAccount account, Movie movie) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return String.format("%s checked %s,%s\n", account.getEmail(), movie.getImdb(), dateFormat.format(date));
    }
}
