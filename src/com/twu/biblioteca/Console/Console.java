package Console;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void scanner(String buf) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();
        buf = result;
    }

    public void showWelcome(){
        print("Welcome\n");
    }

}
