package Console;

import java.util.Scanner;

public class Console {
    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public String scaner() {
        Scanner scanner = new Scanner(System.in);
        String  result = scanner.next();
        return result;
    }

    public void showWelcome(){
        print("Welcome\n");
    }

}
