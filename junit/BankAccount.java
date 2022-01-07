package com.ibm.junit.junit_project;
import com.ibm.junit.junit_project.NotEnoughFundsException;

public class BankAccount {
	
private Integer balance;
    
    // Create a constructor
    public BankAccount(Integer initialBalance) {
        balance = initialBalance;
    }
 
    // Add method to calculate
    // balance amount after withdrawal
    public Integer withdraw(Integer amount) {
        if (balance < amount) {
            throw new NotEnoughFundsException(amount, balance);
        }
        balance -= amount;
        return balance;
    }

}
