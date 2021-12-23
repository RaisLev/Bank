package com.company;

public class Main {

    public static void main(String[] args)
    {
        BankCustomer user_1 = new BankCustomer("Ирина Захарова", "EDVVX", "mirashvili@gmail.com");
        BankCustomer user_2 = new BankCustomer("Анин Илья", "sdfdfg", "jkdfc@dkgjjsd");

        ATM atm_machine1 = new ATM();
        double check1;
        double check2;

        check2 = atm_machine1.Show_SavingBalance(user_1);
        System.out.println("баланс сберегательного счёта1: " + check2);

        atm_machine1.Saving_up(user_1, 100);
        check2 = atm_machine1.Show_SavingBalance(user_1);
        System.out.println("баланс сберегательного счёта1: " + check2);

        atm_machine1.Saving_down(user_1, 100);
        check2 = atm_machine1.Show_SavingBalance(user_1);
        System.out.println("баланс сберегательного счёта1: " + check2);

        System.out.println();

        check1 = atm_machine1.Show_CurrentBalance(user_1);
        System.out.println("баланс текущего счёта1: " + check1);

        atm_machine1.Current_up(user_1, 800);
        check1 = atm_machine1.Show_CurrentBalance(user_1);
        System.out.println("баланс текущего счёта1: " + check1);

        atm_machine1.Current_down(user_1, 100);
        check1 = atm_machine1.Show_CurrentBalance(user_1);
        System.out.println("баланс текущего счёта1: " + check1);

        System.out.println();

        atm_machine1.Internal_trans(user_1, 6, 1);
        check1 = atm_machine1.Show_CurrentBalance(user_1);
        check2 = atm_machine1.Show_SavingBalance(user_1);
        System.out.println("баланс текущего счёта1: " + check1);
        System.out.println("баланс сберегательного счёта1: " + check2);

        System.out.println();
        System.out.println();

        double check12;
        double check22;

        check22 = atm_machine1.Show_SavingBalance(user_2);
        System.out.println("баланс сберегательного счёта2: " + check22);

        atm_machine1.Saving_up(user_2, 200);
        check22 = atm_machine1.Show_SavingBalance(user_2);
        System.out.println("баланс сберегательного счёта2: " + check22);

        System.out.println();

        check12 = atm_machine1.Show_CurrentBalance(user_2);
        System.out.println("баланс текущего счёта2: " + check12);

        atm_machine1.Current_up(user_2, 1000);
        check12 = atm_machine1.Show_CurrentBalance(user_2);
        System.out.println("баланс текущего счёта2: " + check12);

        System.out.println();

        atm_machine1.Main_trans(user_1, user_2, 500);
        check1 = atm_machine1.Show_CurrentBalance(user_1);
        check12 = atm_machine1.Show_CurrentBalance(user_2);
        System.out.println("баланс текущего счёта1: " + check1);
        System.out.println("баланс текущего счёта2: " + check12);


        System.out.println();

        System.out.println();
        atm_machine1.Show_transaction(user_1, 0);
        System.out.println();
        atm_machine1.Show_transaction(user_1, 1);

        System.out.println("____");

        System.out.println();
        atm_machine1.Show_transaction(user_2, 0);
        System.out.println();
        atm_machine1.Show_transaction(user_2, 1);

    }
}
