package com.company;

import java.util.ArrayList;

public class ATM
{
    public void Main_trans(BankCustomer person1, BankCustomer person2, double cash_sum)
    {
        if(person1 != person2)
        {
            //System.out.print("Main transaction on " + cash_sum + "$" + ": ");
            Transaction tr_1 = new Transaction(person1.getCurrentCard(), person2.getCurrentCard(), cash_sum, 2); // 0 - CurAcc 1 - SavAcc 2 - internal
            tr_1.StartTransaction();
            int state = tr_1.getStatus();
            if(state == 1)
            {
                person1.AccCur.AddTransaction(tr_1);
                person2.AccSav.AddTransaction(tr_1);
            }
        } else
            System.out.println("Error: use method current_up/down");
    }

    public void Internal_trans(BankCustomer person, double cash_sum, int indef)
    {
        if(indef == 0) //0 - от текущего  к сберегательному
        {
            //System.out.print("Internal transaction on " + cash_sum + "$ " + "to saving: ");
            Transaction tr_1 = new Transaction(person.getCurrentCard(), person.getSavingCard(), cash_sum, 2); // 0 - CurAcc 1 - SavAcc 2 - internal
            tr_1.StartTransaction();
            if(tr_1.getStatus() == 1)
                person.AccSav.CalculateInterest();
            int state = tr_1.getStatus();
            if(state == 1)
            {
                person.AccCur.AddTransaction(tr_1);
                person.AccSav.AddTransaction(tr_1);
            }
        }else if(indef == 1)//1-от сберегательного к текущему
        {
            //System.out.print("Internal transaction on " + cash_sum + "$ " + "to current: ");
            Transaction tr_1 = new Transaction(person.getSavingCard(), person.getCurrentCard(), cash_sum, 2); // 0 - CurAcc 1 - SavAcc 2 - internal
            tr_1.StartTransaction();
            int state = tr_1.getStatus();
            if(state == 1)
            {
                person.AccCur.AddTransaction(tr_1);
                person.AccSav.AddTransaction(tr_1);
            }
        }
    }

    public int Current_up(BankCustomer person, double cash_sum)
    {
        //System.out.print("Current up on " + cash_sum + "$" + ": ");
        if(cash_sum > 0) {
            Transaction tr_1 = new Transaction(person.getCurrentCard(), person.getCurrentCard(), cash_sum, 0); // 0 - CurAcc 1 - SavAcc
            tr_1.StartTransaction();
            int state = tr_1.getStatus();
            if(state == 1)
            {
                person.AccCur.AddTransaction(tr_1);
            }
            return 1;
        }else
            return -1;
    }

    public int Current_down(BankCustomer person, double cash_sum)
    {
        //System.out.print("Current down on " + cash_sum + "$" + ": ");
        if(cash_sum > 0) {
            Transaction tr_1 = new Transaction(person.getCurrentCard(), person.getCurrentCard(), (-1) * cash_sum, 0); // 0 - CurAcc 1 - SavAcc
            tr_1.StartTransaction();
            int state = tr_1.getStatus();
            if(state == 1)
            {
                person.AccCur.AddTransaction(tr_1);
            }
            return 1;
        }else
            return -1;
    }

    public int Saving_up(BankCustomer person, double cash_sum)
    {
        //System.out.print("Saving up on " + cash_sum + "$" + ": ");
        if(cash_sum > 0) {
            Transaction tr_1 = new Transaction(person.getSavingCard(), person.getSavingCard(), cash_sum, 1); // 0 - CurAcc 1 - SavAcc
            tr_1.StartTransaction();
            person.AccSav.CalculateInterest();
            int state = tr_1.getStatus();
            if(state == 1)
            {
                person.AccSav.AddTransaction(tr_1);
            }
            return 1;
        }else
            return -1;
    }

    public int Saving_down(BankCustomer person, double cash_sum)
    {
        //System.out.print("Saving down on " + cash_sum + "$" + ": ");
        if(cash_sum > 0) {
            Transaction tr_1 = new Transaction(person.getSavingCard(), person.getSavingCard(), (-1) *cash_sum, 1); // 0 - CurAcc 1 - SavAcc
            tr_1.StartTransaction();
            int state = tr_1.getStatus();
            if(state == 1)
            {
                person.AccSav.AddTransaction(tr_1);
            }
            return 1;
        }else
            return -1;
    }

    public void Show_transaction(BankCustomer person, int acc_type)
    {
        if(acc_type == 0) // 0 - CurAcc
        {
            System.out.print("транзакции текущего аккаунта: ");
            for(Transaction i: person.AccCur.getTransaction())
            {
                System.out.println();
                System.out.println(i);
            }
        }
        else if(acc_type == 1) // 1 - SavAcc
        {
            System.out.print("транзакции сберегательного аккаунта: ");
            for (Transaction i : person.AccSav.getTransaction())
            {
                System.out.println();
                System.out.println(i);
            }
        }
    }

    public double Show_CurrentBalance(BankCustomer person)
    {
        return person.getCurrentAccount().getCard_Balance();
    }

    public double Show_SavingBalance(BankCustomer person)
    {
        return person.getSavingAccount().getCard_Balance();
    }

}
