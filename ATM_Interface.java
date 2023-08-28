import java.util.Scanner;

class Bank_Account {
    private double balance;

    public Bank_Account(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid amount for withdrawal or insufficient balance.");
        }
    }
}

class ATM {
    private Bank_Account account;
    private Scanner scanner;

    public ATM(Bank_Account account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void showOptions() {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOptions() {
        int choice;
        do {
            showOptions();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        Bank_Account bankAccount = new Bank_Account(1000.0);
        ATM atm = new ATM(bankAccount);
        atm.processOptions();
    }
}
