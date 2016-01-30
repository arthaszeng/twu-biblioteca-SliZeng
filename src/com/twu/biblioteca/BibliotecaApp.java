import Console.Console;
import Library.Book;
import Library.BooksRepository;
import Menu.MainMenu;

import java.util.*;

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

    public void showWelcome(){
        console.print("Welcome\n");
    }


    public void showAllBooks() {
        ListIterator<Map.Entry<String,Book>> i=new ArrayList<Map.Entry<String,Book>>
                (booksMap.entrySet()).listIterator(booksMap.size());

        while(i.hasPrevious()) {
            console.print(i.previous().getValue().getName() + "\n");
        }

    }
}
