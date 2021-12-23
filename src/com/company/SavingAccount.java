package com.company;

public class SavingAccount extends Account
{
    public int InterestRate = 6;

    public SavingAccount(double Balance) {
        super(Balance);
    }

    public void CalculateInterest()
    {
        this.Balance += this.Balance*InterestRate/100;
    }
    
}
