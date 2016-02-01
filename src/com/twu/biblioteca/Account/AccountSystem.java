package Account;

import java.util.HashMap;

public class AccountSystem {
    HashMap <String, BaseAccount> accountHashMap;

    public AccountSystem() {
        accountHashMap = new HashMap<String, BaseAccount>();
        accountHashMap.put("admin", new BaseAccount("admin", "admin", "admin", "admin"));
    }

    public void register(String name, String email, String phoneNumber, String password) {
        accountHashMap.put(email, new BaseAccount(name, email, phoneNumber, password));
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
