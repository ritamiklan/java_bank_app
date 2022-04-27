package JavaBankApplication;

// ************************************************************************
// BankProgram.java	 Template created on 15.9.2016
// - The program class for the BankApplication exercise
// ************************************************************************
import java.util.Scanner;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class BankProgram {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> accountList = new ArrayList<Account>();

	// *** DO NOT change anything in the main method ***
	public static void main(String[] args) {
		int choice = -1;

		while (choice != 0) {

			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}

			displayMenu();
			choice = Integer.parseInt(input.nextLine());
		}

		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}

	private static void displayMenu() {
		String line = "-----------------------------------------------------"
				+ "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | "
				+ "3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}

	// *** NB! Edit only the methods below. DO NOT add any other methods! ***

	private static void listAccounts() {
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		
		System.out.print("\n*** Account list ***\n");

		String allAccounts = "";

		for (Account accountObject : accountList) {

			allAccounts += "Number: " + accountObject.getAccountNumber() + " | Balance: " + twoDecimals.format(accountObject.getBalance())
					+ "\n";
		}

		System.out.println(allAccounts);
	}

	private static void addAccount() {
		System.out.print("\n*** Add an account ***\n");

		String accountNumber = input.nextLine();

		if (findAccount(accountNumber) == null) {
			accountList.add(new Account(accountNumber));
			
			
			System.out.println();
			System.out.println("Account created successfully!");

		} else {
			System.out.println();
			System.out.println("Account not created. Account " + accountNumber + " exists already!");
		}
	}

	// Finds an account in accountList by given account number.
	// Returns either a reference to the account object
	// OR null if the account is not found in accountList.

	private static Account findAccount(String accountNumber) {

		Account myAccount = null;

		for (Account accountObject : accountList) {

			String test = accountObject.getAccountNumber();

			if (test.equals(accountNumber)) {

				myAccount = accountObject;
			}
		}

		return myAccount;
	}

	private static void depositMoney() {

		
		System.out.print("\n*** Deposit money to an account ***\n");

		System.out.print("Enter account number: ");
		String number = input.nextLine();

		Account myAccount = null;

		myAccount = findAccount(number);

		if (myAccount != null) {

			System.out.print("Enter the amount to be deposited: ");
			Double amount = Double.parseDouble(input.nextLine());

			if (amount >= 0) {

				myAccount.deposit(amount);
				
				System.out.println();
				System.out.println("Deposit completed successfully!");

			} else {
				System.out.println();
				System.out.println("Cannot deposit a negative amount!");
			}

		} else {
			
			System.out.println();
			System.out.println("Account " + number + " does not exist!");
		}

	}

	private static void withdrawMoney() {
		System.out.print("\n*** Withdraw money from an account ***\n");

		System.out.print("Enter account number: ");
		String number = input.nextLine();

		Account myAccount = null;

		myAccount = findAccount(number);

		if (myAccount == null) {
			System.out.println();
			System.out.println("Account " + number + " does not exist!");
			return;
		}

		System.out.print("Enter the amount to be withdrawn: ");
		Double amount = Double.parseDouble(input.nextLine());

		if (amount < 0) {

			System.out.println();
			System.out.println("Cannot withdraw a negative amount!");
			return;
		}

		if (myAccount.withdraw(amount) == true) {

			System.out.println();
			System.out.println("Withdraw completed successfully!");

		} else {

			System.out.println();
			System.out.println("Withdrawal not completed. Available balance is too low.");
		}

	}

	private static void deleteAccount() {
		System.out.print("\n*** Delete an account ***\n");

		System.out.println("Enter account number: ");
		String deleteThis = input.nextLine();

		Account myAccount = null;
				
		myAccount = findAccount(deleteThis);
		
		if (myAccount != null) {

		accountList.remove(myAccount);

		System.out.println();
		System.out.println("Account deleted successfully!");
		} else {
			
			System.out.println();
			System.out.println("Nothing deleted. Account " + deleteThis + " does not exist!");
		}	
	}
}
// End
