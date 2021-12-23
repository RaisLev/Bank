package com.company;

public class ATMCard
{
    private String PIN;
    private String Card_ID;
    private Account account;

    public ATMCard (String PIN, String Card_ID, Account account)
    {
        this.PIN = PIN;
        this.Card_ID = Card_ID;
        this.account = account;
    }

    String[] getCardInfo()
    {
        String infoArray[] = new String[2];
        infoArray[0] = this.PIN;
        infoArray[1] = this.Card_ID;

        return infoArray;
    }

    public void newPIN(String new_PIN)
    {
        this.PIN = new_PIN;
    }

    public Account getAccount()
    {
        return account;
    }

    @Override
    public String toString() {
        return "{" +
                "Card_ID = '" + Card_ID + '\'' +
                '}';
    }
}
