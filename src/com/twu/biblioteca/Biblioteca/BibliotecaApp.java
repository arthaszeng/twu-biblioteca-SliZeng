package Biblioteca;

import Console.Console;
import Format.BookFormat;
import Library.Book;
import Library.BooksRepository;
import Menu.MainMenu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public class BibliotecaApp {
    private final Console console;
    public MainMenu menu;
    private LinkedHashMap<String, Book> booksMap;

    public BibliotecaApp(Console console, MainMenu mainMenu) {
        this.console = console;
        this.menu = mainMenu;

        BooksRepository booksRepository = new BooksRepository();
        booksRepository.repositoryInit();
        booksMap = booksRepository.getBooks();
    }

    public void showAllBooks() {
        ListIterator<Map.Entry<String,Book>> iterator = new ArrayList<Map.Entry<String,Book>>
                (booksMap.entrySet()).listIterator(booksMap.size());

        while(iterator.hasPrevious()) {
            console.print(iterator.previous().getValue().getName() + "\n");
        }
    }


    public void showAllBooksDetails() {
        ListIterator<Map.Entry<String,Book>> iterator = new ArrayList<Map.Entry<String,Book>>
                (booksMap.entrySet()).listIterator(booksMap.size());

        while(iterator.hasPrevious()) {
            console.print(BookFormat.detailsFormat(iterator.previous().getValue()) + "\n");
        }
    }


    public static void main(String args[]) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Console(), new MainMenu(new Console()));

        bibliotecaApp.menu.selectOption("a").operate(bibliotecaApp);
    }
}