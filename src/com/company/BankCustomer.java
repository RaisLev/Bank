package com.company;

public class BankCustomer
{
    private String CustomerName;
    private String Adress;
    private String Email;
    public SavingAccount AccSav;
    public CurrentAccount AccCur;

    public BankCustomer(String CustomerName, String Adress, String Email)
    {
        this.CustomerName = CustomerName;
        this.Adress = Adress;
        this.Email = Email;

        this.AccSav = new SavingAccount(0);
        this.AccCur = new CurrentAccount(0);
    }

    public void CustomerInfo()
    {
        System.out.println("Name = " + CustomerName);
        System.out.println("Adress = " + Adress);
        System.out.println("Emaill = " + Email);

    }

    public Account getCurrentAccount()
    {
        return AccCur;
    }

    public Account getSavingAccount()
    {
        return AccSav;
    }

    public ATMCard getCurrentCard()
    {
        Account acc = getCurrentAccount();
        return acc.getCard();
    }

    public ATMCard getSavingCard()
    {
        Account acc = getSavingAccount();
        return acc.getCard();
    }

}
