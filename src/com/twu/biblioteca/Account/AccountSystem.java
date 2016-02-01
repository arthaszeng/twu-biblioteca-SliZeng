package Account;

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
        BaseAccount targetAccount = accountHashMap.get(email);
        if (targetAccount == null){
            return null;
        }else {
            return targetAccount;
        }
    }
}
