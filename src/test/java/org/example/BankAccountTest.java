package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    @Test
    public void testGetBalance() {
        BankAccount account = new BankAccount("Аня", 100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testNegativ() {
        BankAccount account = new BankAccount("Аня", 100);
        account.withdraw(150);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("Аня", 100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

}