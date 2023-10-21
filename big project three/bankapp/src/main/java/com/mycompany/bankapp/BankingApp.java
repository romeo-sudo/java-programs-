
package com.mycompany.bankapp;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

class Bank {
    private Map<String, Double> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, 0.0);
            JOptionPane.showMessageDialog(null, "Account created successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Account already exists.");
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            balance += amount;
            accounts.put(accountNumber, balance);
            JOptionPane.showMessageDialog(null, "Deposit successful. Current balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(accountNumber, balance);
                JOptionPane.showMessageDialog(null, "Withdrawal successful. Current balance: " + balance);
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient funds.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found.");
        }
    }

    public double getBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        } else {
            return -1; // Account not found
        }
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
         // Load the image
        ImageIcon icon = new ImageIcon("bank_logo.png");


        while (true) {
            String input = JOptionPane.showInputDialog(
                "1. Create Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Exit\nEnter your choice:"
            );

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    String accountNumber = JOptionPane.showInputDialog("Enter account number:");
                    bank.createAccount(accountNumber);
                    break;
                case 2:
                    accountNumber = JOptionPane.showInputDialog("Enter account number:");
                    double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount:"));
                    bank.deposit(accountNumber, depositAmount);
                    break;
                case 3:
                    accountNumber = JOptionPane.showInputDialog("Enter account number:");
                    double withdrawalAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdrawal amount:"));
                    bank.withdraw(accountNumber, withdrawalAmount);
                    break;
                case 4:
                    accountNumber = JOptionPane.showInputDialog("Enter account number:");
                    double balance = bank.getBalance(accountNumber);
                    if (balance == -1) {
                        JOptionPane.showMessageDialog(null, "Account not found.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Account balance: " + balance);
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please choose a valid option.");
            }
        }
    }
}
