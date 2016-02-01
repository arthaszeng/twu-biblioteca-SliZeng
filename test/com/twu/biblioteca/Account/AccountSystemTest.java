package Account;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountSystemTest {
    @Test
    public void testLoginForUser() throws Exception {
        AccountSystem accountSystem = new AccountSystem();
        BaseAccount baseAccount = accountSystem.register("Sli", "sli616@163.com", "15884373717", "123456");
        String role = accountSystem.checkAccount("sli616@163.com");

        assertEquals("user", role);
    }
}
