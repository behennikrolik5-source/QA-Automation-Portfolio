package org.example;

public class BankAccount {
    protected String owner;
    protected double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0){
            System.out.println("Нельзя внести отрицательный депозит");
            return;
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Ошибка вывода, нельзя вывести отрицательную сумму или большее кол-во денег чем баланс");
        }
    }
}
