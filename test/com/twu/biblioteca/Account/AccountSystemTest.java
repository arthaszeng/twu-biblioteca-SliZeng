package Account;

import Console.Console;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class AccountSystemTest {
    private Console console;
    private AccountSystem accountSystem;

    @Before
    public void setUp() throws Exception {
        console = mock (Console.class);
        accountSystem = new AccountSystem(console);
    }

    @Test
    public void testRegisterSuccessfully() throws Exception {
        AccountSystem accountSystem = new AccountSystem(console);
        boolean flag = accountSystem .register("Sli", "sli616@163.com", "15884373717", "123456");

        assertTrue(flag);
        verify(console, times(1)).print("Register successfully.\n");
    }


    @Test
    public void testRegisterFailed() throws Exception {
        AccountSystem accountSystem = new AccountSystem(console);
        boolean flag = accountSystem .register("admin", "admin", "admin", "admin");

        assertFalse(flag);
        verify(console, times(1)).print("Register failed.\n");
    }

    @Test
    public void testCheckAccount() throws Exception {

        accountSystem.register("Sli", "sli616@163.com", "15884373717", "123456");
        BaseAccount targetAccount = accountSystem.checkAccount("sli616@163.com");

        assertEquals("sli616@163.com", targetAccount.getEmail());
        assertEquals("Sli", targetAccount.getName());
        assertEquals("123456", targetAccount.getPassword());
        assertEquals("15884373717", targetAccount.getPhoneNumber());
        assertEquals("user", targetAccount.getRole());
    }
}
