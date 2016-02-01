package Account;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountSystemTest {
    @Test
    public void testLoginForUser() throws Exception {
        AccountSystem accountSystem = new AccountSystem();
        BaseAccount baseAccount = accountSystem.register("name", "email address", "phone number", "password");
        String role = accountSystem.checkAccount("name");

        assertEquals("user", role);
    }
}
