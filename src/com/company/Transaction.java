package com.company;

import java.util.ArrayList;
import java.util.Date;


public class Transaction
{
    public Date date;
    private int status;
    ATMCard Card1;
    ATMCard Card2;
    private double TransactionSum;
    private double balance1;
    private double balance2;
    private boolean type_transaction;
    private boolean is_one_account = false;
    private int account;

    public Transaction(ATMCard Card1, ATMCard Card2, double TransactionSum, int account)
    {
        this.Card1 = Card1;
        this.Card2 = Card2;
        this.TransactionSum = TransactionSum;
        balance1 = Card1.getAccount().getCard_Balance();
        balance2 = Card2.getAccount().getCard_Balance();
        this.account = account; //0 - CurAcc 1 - SavAcc

        //определение типа транзакции
        if(Card1 == Card2)
        {
            this.type_transaction = true;//пополнение одной карты
        }else
        {
            this.type_transaction = false;//взаимодействие между разными картами
        }
    }

    public void StartTransaction()
    {
        if(type_transaction == false)
        {
            if (balance1 >= TransactionSum)
            {
                Card1.getAccount().editBalance((-1)*TransactionSum);
                balance1 = Card1.getAccount().getCard_Balance();
                Card2.getAccount().editBalance(TransactionSum);
                balance2 = Card2.getAccount().getCard_Balance();
                end_Transaction(1);
            }
            else if(balance1 < TransactionSum)
            {
                end_Transaction(-1);
            }
            else {
                this.status = 0;
            }
        }
        else if(type_transaction == true)
        {
            is_one_account = true;
            if(TransactionSum >= 0)
            {
                if (account == 0)
                {
                    Card1.getAccount().editBalance(TransactionSum);
                    balance1 = Card1.getAccount().getCard_Balance();
                    end_Transaction(1);//!!!! cur
                } else {
                    Card1.getAccount().editBalance(TransactionSum);
                    balance1 = Card1.getAccount().getCard_Balance();
                    end_Transaction(1);//!!!!sav
                }
            }
            else if(TransactionSum < 0 && TransactionSum >= (-1)*Card1.getAccount().getCard_Balance())
            {
                if (account == 0)
                {
                    Card1.getAccount().editBalance(TransactionSum);
                    balance1 = Card1.getAccount().getCard_Balance();
                    end_Transaction(1);//!!!!cur
                } else {
                    Card1.getAccount().editBalance(TransactionSum);
                    balance1 = Card1.getAccount().getCard_Balance();
                    end_Transaction(1);//!!!!sav
                }
            } else{
                end_Transaction(-1);
            }
        }
    }

    public void end_Transaction(int c)
    {
        date = new Date();
        this.status = c;
        if(c == 1)
        {
            System.out.println("Transaction verify! " + "Дата операции: " + date);
        }
        else {
            System.out.println("Transaction cancel 'Недостаточно средств' " + "Дата операции: " + date);
        }
    }

    @Override
    public String toString() {
        if(is_one_account)
        {
            return  "Transaction: " +
                    "\n Date =' " + date + '\'' +
                    "\n status = " + status +
                    "\n Card1 = " + Card1 +
                    "\n TransactionSum = " + Math.abs(TransactionSum) +"$"+
                    "\n balance1 = " + balance1 +"$"+
                    "\n type_transaction = " + type_transaction +
                    "\n account = " + account +
                    ';';
        } else

            return  "Transaction: " +
                    "\n Date =' " + date + '\'' +
                    "\n status = " + status +
                    "\n Card1 = " + Card1 +
                    "\n Card2 = " + Card2 +
                    "\n TransactionSum = " + Math.abs(TransactionSum) +"$"+
                    "\n balance1 = " + balance1 +"$"+
                    "\n balance2 = " + balance2 +"$"+
                    "\n type_transaction = " + type_transaction +
                    "\n account = " + account +
                    ';';
    }

    int getStatus()
    {
        return status;
    }
}
