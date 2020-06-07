package me.suski;

import me.suski.BankAccount.AccountType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup() {
        account = new BankAccount("Bartek", "Suski",
                1000, AccountType.CHECKING);
        System.out.println("Running Test...");
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {100, true, 1100},
                {200, true, 1200},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000, true, 2000}
        });
    }

    @Test
    public void deposit() throws Exception {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}
