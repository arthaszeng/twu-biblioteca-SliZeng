package Account;

import Console.Console;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.hamcrest.core.Is.is;
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

    @Test
    public void testLoginSuccessfully() throws Exception {
        when(console.scaner()).thenReturn("admin");

        BaseAccount targetAccount = accountSystem.login();
        assertEquals("admin", targetAccount.getEmail());
        assertEquals("admin", targetAccount.getName());
        assertEquals("admin", targetAccount.getPassword());
        assertEquals("admin", targetAccount.getPhoneNumber());
        assertEquals("user", targetAccount.getRole());

    }
    @Test
    public void testLoginFailed() throws Exception {
        when(console.scaner()).thenReturn("wrong");

        BaseAccount targetAccount = accountSystem.login();
        assertEquals(targetAccount, is(Null.NULL));

    }
}
