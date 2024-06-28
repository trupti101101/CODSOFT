/*Task 3 : ATM INTERFACE
1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure of their transactions. */


import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the bank account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance of the account
    public double getBalance() {
        return balance;
    }

    // Method to deposit a specified amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid Input: Deposit amount must be positive.");
        }
    }

    // Method to withdraw a specified amount from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else if (amount > balance) {
            System.out.println("Invalid Input: Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid Input: Withdrawal amount must be positive.");
            return false;
        }
    }
}

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize the ATM with a bank account and a scanner for user input
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user choices
    public void displayMenu() {
        System.out.println("== Welcome to the ATM ==");
        boolean continueUsingATM = true;

        // Loop to keep displaying the menu until the user chooses to exit
        while (continueUsingATM) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            // Switch case to handle the user's menu choice
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    continueUsingATM = false;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid Input: Please choose a valid option.");
            }
        }
    }

    // Method to check and display the current balance of the account
    public void checkBalance() {
        System.out.printf("Current Balance: %.2f\n", account.getBalance());
    }

    // Method to handle the deposit process
    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.printf("Deposited: %.2f\n", amount);
        checkBalance();
    }

    // Method to handle the withdrawal process
    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("Withdrew: %.2f\n", amount);
        }
        checkBalance();
    }

    // Main method to create a bank account and start the ATM
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.0); // Initial balance for example
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}

