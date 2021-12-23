package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Account {
    public double Balance;
    protected ATMCard Card;
    protected ArrayList<Transaction> Trans = new ArrayList<>();


    public Account(double Balance)
    {
        this.Balance = Balance;
        String PIN = getRandomString(4, 0);
        String ID = getRandomString(10, 1);
        this.Card = new ATMCard(PIN, ID, this);
    }

    public void AddTransaction(Transaction newTransaction) {
        Trans.add(newTransaction);
    }

    public ArrayList<Transaction> getTransaction() {
        return (Trans);
    }

    public ATMCard getCard() {
        return Card;
    }

    public double getCard_Balance() {
        return Balance;
    }

    public void editBalance(double CacheSumm) {
        this.Balance = Balance + CacheSumm;
    }

    public static String getRandomString(int length, int type)
    {
        if(type == 0) {
            String str = "0123456789";
            Random random = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++)
            {
                int number = random.nextInt(length - 1);
                sb.append(str.charAt(number));
            }
            return sb.toString();

        }else if(type == 1)
        {
            String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++)
            {
                int number = random.nextInt(length - 1);
                sb.append(str.charAt(number));
            }
            return sb.toString();
        }else
            return null;
    }

}
