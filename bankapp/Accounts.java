package bankapp;

public abstract class Accounts implements IBaseRate {
    // List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int index = 1000;
    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Accounts(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoDigit = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoDigit + uniqueID + randomNumber;
    }

    public void compound() {
        double accuredInterest = balance * (rate / 100);
        balance = balance + accuredInterest;
        System.out.println("Accured Interest $" + accuredInterest);
        printfBalance();
    }

    // List Common methods
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing amount $" + amount);
        printfBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing amount $" + amount);
        printfBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transfering amount $" + amount + " to " + toWhere);
        printfBalance();
    }

    private void printfBalance() {
        System.out.println("Yoour Balance is $" + balance);
    }

    public void showInfo() {
        System.out.println(
                "NAME: " + name +
                        "\nACCOUNT: " + accountNumber +
                        "\nBALANCE: " + balance +
                        "\nRATE: " + rate);
    }

}
