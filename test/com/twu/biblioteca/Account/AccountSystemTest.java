package Account;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountSystemTest {

    @Test
    public void testRegister() throws Exception {

    }

    @Test
    public void testCheckAccount() throws Exception {
        AccountSystem accountSystem = new AccountSystem();
        accountSystem.register("Sli", "sli616@163.com", "15884373717", "123456");
        BaseAccount targetAccount = accountSystem.checkAccount("sli616@163.com");

        assertEquals("sli616@163.com", targetAccount.getEmail());
        assertEquals("Sli", targetAccount.getName());
        assertEquals("123456", targetAccount.getPassword());
        assertEquals("15884373717", targetAccount.getPhoneNumber());
        assertEquals("user", targetAccount.getRole());
    }
}
