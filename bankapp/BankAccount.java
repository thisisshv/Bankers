package bankapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccount {

    public static void main(String[] args) {
        List<Accounts> accounts = new LinkedList<Accounts>();

        // Read csv file then create account based on that data
        String file = "D:\\Users\\Mohit Agarwal\\Downloads\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("ACCOUNT TYPE NOT FOUND!");
            }
        }

        for (Accounts acc : accounts) {
            System.out.println("\n***********************\n");
            acc.showInfo();
            System.out.println("\n***********************\n");
        }

    }

}
