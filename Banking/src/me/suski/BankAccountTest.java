package me.suski;

import me.suski.BankAccount.AccountType;
import org.junit.*;

import static junit.framework.TestCase.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before test class. Count = " + count++);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This executes after test class. Count = " + count++);
    }

    @Before
    public void setup() {
        account = new BankAccount("Bartek", "Suski",
                1000, AccountType.CHECKING);
        System.out.println("Running a test...");
    }

    @After
    public void tearDown() {
        System.out.println("Count = " + count++);
    }

    @Test
    public void deposit() throws Exception {
        double balance = account.deposit(200, true);
        assertEquals(1200, balance, 0);
    }

    @Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600, true);
        assertEquals(400, balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        account.withdraw(600, false);
    }

    @Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() throws Exception {
        account.withdraw(200, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue("The account is NOT a checking account",
                account.isChecking());
    }
}