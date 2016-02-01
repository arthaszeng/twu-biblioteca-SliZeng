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
    private LinkedHashMap<String, Book> currentBooksMap;
    private LinkedHashMap<String, Book> totalBooksMap;
    private Map<String, Book> checkedBooksMap;

    public BibliotecaApp(Console console, MainMenu mainMenu) {
        this.console = console;
        this.menu = mainMenu;

        BooksRepository booksRepository = new BooksRepository();

        totalBooksMap = booksRepository.getBooks();
        currentBooksMap = (LinkedHashMap<String, Book>) totalBooksMap.clone();
        checkedBooksMap = new HashMap<String, Book>();
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

    public Boolean checkout(String isbn) {
        if (currentBooksMap.containsKey(isbn)) {
            console.print("Thank you! Enjoy the book.\n");
        }else {
            console.print("That book is not available\n");
            return false;
        }
        this.currentBooksMap.remove(isbn);
        return true;
    }

    public Boolean returnBook(String isbn) {

       if (!currentBooksMap.containsKey(isbn) && totalBooksMap.containsKey(isbn)) {
            Book book = totalBooksMap.get(isbn);
            currentBooksMap.put(isbn, book);
            this.console.print("Thank you for returning the book.\n");
            return true;
        }else {
            this.console.print("That is not a valid book to return.\n");
            return false;
        }
    }







    public static void main(String args[]) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Console(), new MainMenu(new Console()));
        Console console = mock(Console.class);

        bibliotecaApp.menu.selectOption("l").operate(bibliotecaApp);

        bibliotecaApp.menu.addOption(new ErrorOption(console));
        bibliotecaApp.menu.addOption(new CheckOutOption());

        bibliotecaApp.currentBooksMap.remove("000001");
        System.out.println(bibliotecaApp.totalBooksMap.containsKey("000001"));
        System.out.println(bibliotecaApp.currentBooksMap.containsKey("000001"));

//        bibliotecaApp.menu.selectOption("c").operate(bibliotecaApp);
//        bibliotecaApp.menu.selectOption("l").operate(bibliotecaApp);
//
//        bibliotecaApp.menu.selectOption("c").operate(bibliotecaApp);
//        bibliotecaApp.menu.selectOption("l").operate(bibliotecaApp);
//
//        bibliotecaApp.returnBook("000001");
//        bibliotecaApp.menu.selectOption("l").operate(bibliotecaApp);
    }

}
