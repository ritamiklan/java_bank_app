package JavaBankApplication;

// ************************************************************************
// Account.java	  Template created on15.9.2016
// - The class for Account objects
// ************************************************************************
public class Account {
	// Fields

	private String accountNumber;
	private double balance;

	// Constructor

	public Account(String accountNumber) {

		this.accountNumber = accountNumber;
		balance = 0;

	}

	// Methods

	public void deposit(double amount) {

		balance = balance + amount;

	}

	public String getAccountNumber() {

		return accountNumber;
	}

	public double getBalance() {

		return balance;
	}

	public boolean withdraw(double amount) {

		boolean enoughMoney = false;

		if ((balance - amount) >= 0) {

			balance = balance - amount;

			enoughMoney = true;
		}

		return enoughMoney;

	}
}
// End
