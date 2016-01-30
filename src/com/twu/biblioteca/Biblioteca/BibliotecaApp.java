package Biblioteca;

import Console.Console;
import Format.BookFormat;
import Library.Book;
import Library.BooksRepository;
import Menu.Menu.MainMenu;
import Menu.Option.CheckOutOption;
import Menu.Option.ErrorOption;

import java.util.*;

import static org.mockito.Mockito.mock;

public class BibliotecaApp {
    private final Console console;
    public MainMenu menu;
    private LinkedHashMap<String, Book> booksMap;
    private Map<String, Book> checkedBooksMap;

    public BibliotecaApp(Console console, MainMenu mainMenu) {
        this.console = console;
        this.menu = mainMenu;

        BooksRepository booksRepository = new BooksRepository();
        booksRepository.repositoryInit();
        booksMap = booksRepository.getBooks();
        checkedBooksMap = new HashMap<String, Book>();
    }

    public void showAllBooks() {
        ListIterator<Map.Entry<String,Book>> iterator = new ArrayList<Map.Entry<String,Book>>
                (booksMap.entrySet()).listIterator(booksMap.size());

        while(iterator.hasPrevious()) {
            Book buffer = iterator.previous().getValue();
            console.print(buffer.getName() + "\n");
        }
    }

    public void showAllBooksDetails() {
        ListIterator<Map.Entry<String,Book>> iterator = new ArrayList<Map.Entry<String,Book>>
                (booksMap.entrySet()).listIterator(booksMap.size());

        while(iterator.hasPrevious()) {
            Book buffer = iterator.previous().getValue();
            console.print(BookFormat.detailsFormat(buffer) + "\n");
        }
    }

    public Boolean checkout(String isbn) {
        if (booksMap.containsKey(isbn)) {
            console.print("Thank you! Enjoy the book.\n");
        }else {
            console.print("That book is not available\n");
            return false;
        }
        this.booksMap.remove(isbn);
        return true;
    }

    public static void main(String args[]) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Console(), new MainMenu(new Console()));
        Console console = mock(Console.class);

        bibliotecaApp.menu.selectOption("l").operate(bibliotecaApp);

        bibliotecaApp.menu.addOption(new ErrorOption(console));
        bibliotecaApp.menu.addOption(new CheckOutOption());

        bibliotecaApp.menu.selectOption("c").operate(bibliotecaApp);
        bibliotecaApp.menu.selectOption("l").operate(bibliotecaApp);

        bibliotecaApp.menu.selectOption("c").operate(bibliotecaApp);
        bibliotecaApp.menu.selectOption("l").operate(bibliotecaApp);
    }

    public Boolean returnBook(String isbn) {

    }
}
