import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayBalance() {
        System.out.println("Account: " + accountNumber + " | Balance: $" + balance);
    }
}

class BankingSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        String accountNumber = "AC" + (accounts.size() + 1);
        BankAccount newAccount = new BankAccount(name, accountNumber);
        accounts.add(newAccount);
        System.out.println("Account created successfully. Your Account Number: " + accountNumber);
    }

    private BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void depositMoney() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        BankAccount account = findAccount(accNum);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawMoney() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        BankAccount account = findAccount(accNum);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        BankAccount account = findAccount(accNum);

        if (account != null) {
            account.displayBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using our banking system.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        system.start();
    }
}
