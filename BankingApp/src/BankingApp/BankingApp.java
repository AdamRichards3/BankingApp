package BankingApp;

import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {
		BankAccount obj = new BankAccount("Duciee", "00000001");
		obj.showMenu();

	}

}

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	BankAccount(String cname, String cID){
		customerName = cname;
		customerID = cID;
	}
	
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount){
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount; 
		}
	}
	
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Depsoited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No Transaction Occured");
		}
	}
	
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("Your id is: " + customerID);
		System.out.println(" ");
		
		System.out.println("A : Check your balance");
		System.out.println("B : Deposit");
		System.out.println("C : Withdraw");
		System.out.println("D : Previous Transaction");
		System.out.println("E : Exit");
		
		do {
			System.out.println("---------------------------------------------------");
			System.out.println("Enter your option");
			System.out.println("---------------------------------------------------");
			System.out.println(" ");
			
			switch (option) {
			
			case 'A':
				System.out.println("---------------------");
				System.out.println("Balance = " + balance);
				System.out.println("---------------------");
				System.out.println(" ");
				break;
				
			case 'B':
				System.out.println("---------------------");
				System.out.println("Enter an ammount to deposit");
				System.out.println("---------------------");
				
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println(" ");
				break;
				
			case 'D':
				System.out.println("---------------------");
				getPreviousTransaction();
				System.out.println("---------------------");
				System.out.println(" ");
				break;
				
			case 'E':
				System.out.println("=========================================================");
				break;
				
			default:
				System.out.println("Invalid option! Please try again...");
				break;
				
			}
		}
		while(option != 'E');
			System.out.println("Thank you for using our service");
			
		scanner.close();
	}
}