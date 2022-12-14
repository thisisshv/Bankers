package bankapp;

public class Checking extends Accounts {
    // List properties specific to checking account
    private int debitCardNumber;
    private int debitCardPIN;

    // Constructor to initialize setting of checking account
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    // List methods specific to checking account
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println(
                "Features: " +
                        "\n Debit Card Number: " + debitCardNumber +
                        "\n Debit Card PIN: " + debitCardPIN);
    }

}
