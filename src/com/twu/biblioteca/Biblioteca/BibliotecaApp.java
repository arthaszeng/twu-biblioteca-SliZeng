package Biblioteca;

import Account.AccountSystem;
import Account.BaseAccount;
import Console.Console;
import Format.BookFormat;
import Format.LogFormat;
import Format.MovieFormat;
import Library.Book;
import Library.BooksRepository;
import Library.Movie;
import Library.MoviesRepository;
import Menu.Menu.MainMenu;

import java.util.*;

public class BibliotecaApp {
    private final Console console;
    public MainMenu menu;
    public AccountSystem accountSystem;
    private BaseAccount currentVisitor = null;
    private List<String> operationLog = new ArrayList<String>();

    private LinkedHashMap<String, Book> currentBooksMap;
    private LinkedHashMap<String, Book> totalBooksMap;

    private LinkedHashMap<String, Movie> currentMoviesMap;
    private LinkedHashMap<String, Movie> totalMoviesMap;


    public BibliotecaApp(Console console, MainMenu mainMenu) {
        this.console = console;
        this.menu = mainMenu;

        BooksRepository booksRepository = new BooksRepository();
        MoviesRepository moviesRepositroy = new MoviesRepository();

        totalBooksMap = booksRepository.getMaps();
        currentBooksMap = (LinkedHashMap<String, Book>) totalBooksMap.clone();

        totalMoviesMap = moviesRepositroy.getMap();
        currentMoviesMap = (LinkedHashMap<String, Movie>) totalMoviesMap.clone();

        accountSystem = new AccountSystem(this.console);

    }

    public void showAllBooks() {
        ListIterator<Map.Entry<String,Book>> iterator = new ArrayList<Map.Entry<String,Book>>
                (currentBooksMap.entrySet()).listIterator(currentBooksMap.size());

        while(iterator.hasPrevious()) {
            Book buffer = iterator.previous().getValue();
            console.print(buffer.getName() + "\n");
        }
    }

    public void showAllBooksDetails() {
        ListIterator<Map.Entry<String,Book>> iterator = new ArrayList<Map.Entry<String,Book>>
                (currentBooksMap.entrySet()).listIterator(currentBooksMap.size());

        while(iterator.hasPrevious()) {
            Book buffer = iterator.previous().getValue();
            console.print(BookFormat.format(buffer) + "\n");
        }
    }

    public Boolean checkout(String key) {
        if (currentBooksMap.containsKey(key)) {

            console.print("Thank you! Enjoy the book.\n");

            currentBooksMap.remove(key);
            Book book = totalBooksMap.get(key);
            currentVisitor.checkoutBooks(book);
            addOperationLog(LogFormat.format(currentVisitor, book));
        } else if (currentMoviesMap.containsKey(key)){

            console.print("Thank you! Enjoy the movie.\n");

            currentMoviesMap.remove(key);
            Movie movie = totalMoviesMap.get(key);
            currentVisitor.checkoutMovies(movie);
            addOperationLog(LogFormat.format(currentVisitor, movie));

        }else{

            console.print("That is not available\n");
            return false;
        }

        return true;
    }

    public Boolean returnBook(String key) {
        if (!currentBooksMap.containsKey(key) && totalBooksMap.containsKey(key)) {
            Book book = totalBooksMap.get(key);
            currentBooksMap.put(key, book);
            this.console.print("Thank you for returning the book.\n");
            return true;
        }else if(!currentMoviesMap.containsKey(key) && totalMoviesMap.containsKey(key)) {
            Movie movie = totalMoviesMap.get(key);
            currentMoviesMap.put(key, movie);
            this.console.print("Thank you for returning the movie.\n");
            return true;
        }else {
            this.console.print("That is not a valid book or movie to return.\n");
            return false;
        }
    }

    public void showAllMovies() {

        ListIterator<Map.Entry<String, Movie>> iterator = new ArrayList<Map.Entry<String, Movie>>
                (currentMoviesMap.entrySet()).listIterator(currentMoviesMap.size());

        while(iterator.hasPrevious()) {
            Movie buffer = iterator.previous().getValue();
            console.print(buffer.getName() + "\n");
        }
    }

    public void showAllMOviesDetails() {
        ListIterator<Map.Entry<String, Movie>> iterator = new ArrayList<Map.Entry<String, Movie>>
                (currentMoviesMap.entrySet()).listIterator(currentMoviesMap.size());

        while(iterator.hasPrevious()) {
            Movie buffer = iterator.previous().getValue();
            console.print(MovieFormat.format(buffer) + "\n");
        }
    }

    public void setCurrentVisitor(BaseAccount currentVisitor) {
        this.currentVisitor = currentVisitor;
    }

    public boolean isLogined () {
        return !(currentVisitor == null);
    }

    public void addOperationLog(String message) {

    }

    public static void main(String args[]) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Console(), new MainMenu(new Console()));
        bibliotecaApp.accountSystem.login(bibliotecaApp);
    }

}
