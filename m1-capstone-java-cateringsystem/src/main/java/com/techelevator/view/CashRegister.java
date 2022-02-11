package com.techelevator.view;

public class CashRegister {

    private double userAccountBalance = 0.00;
    private int depositedAmount = 0;

    public CashRegister (double userAccountBalance, int depositedAmount){
        this.userAccountBalance = userAccountBalance;
        this.depositedAmount = depositedAmount;
    }

    public double getUserAccountBalance() {
        return userAccountBalance;
    }

    public int getDepositedAmount() {
        return depositedAmount;
    }
}
