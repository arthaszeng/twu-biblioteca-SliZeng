package Account;

import Biblioteca.BibliotecaApp;
import Console.Console;

import java.util.HashMap;

public class AccountSystem {
    private Console console;
    HashMap <String, BaseAccount> accountHashMap;

    public AccountSystem(Console console) {
        this.console = console;
        accountHashMap = new HashMap<String, BaseAccount>();
        accountHashMap.put("admin", new BaseAccount("admin", "admin", "admin", "admin"));
    }

    public boolean register(String name, String email, String phoneNumber, String password) {
        if (accountHashMap.containsKey(email)){
            console.print("Register failed.\n");
            return false;
        }else {
            accountHashMap.put(email, new BaseAccount(name, email, phoneNumber, password));
            console.print("Register successfully.\n");
            return true;
        }
    }

    public BaseAccount checkAccount(String email) {
        return accountHashMap.get(email);
    }

    public BaseAccount login(BibliotecaApp bibliotecaApp) {
        console.print("Please input you email.");
        String email = console.scaner();
        console.print("Please input you password.");
        String password = console.scaner();

        BaseAccount accountBuffer = checkAccount(email);

        if (accountBuffer == null || !password.equals(accountBuffer.getPassword())) {
            console.print("Login failed.");
            return null;
        }
        else {
            console.print("Login successfully.");
            bibliotecaApp.setCurrentVisitor(accountBuffer);
            return accountBuffer;
        }
    }
}
