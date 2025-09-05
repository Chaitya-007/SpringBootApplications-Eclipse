package com.bank;

public class Bank {
	private double balance;

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
		this.balance = 0;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be positive.");
		}
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive.");
		}
		if (amount > balance) {
			throw new IllegalArgumentException("Insufficient funds.");
		}
		balance -= amount;
	}

}