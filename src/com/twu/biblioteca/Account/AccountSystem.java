package Account;

public class AccountSystem {

    public BaseAccount register(String name, String email, String phoneNumber, String password) {
        return new BaseAccount(name, email, phoneNumber, password);
    }

    public String checkAccount(String name) {
    }
}
