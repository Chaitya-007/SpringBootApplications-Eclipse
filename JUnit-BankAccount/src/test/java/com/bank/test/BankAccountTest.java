package com.bank.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.Bank;

public class BankAccountTest {
	private Bank account;
	
//	@BeforeAll
//	public void connection() {
//		System.out.println("Database Connected");
//	}
	
	@BeforeEach
	public void setUP() {
		System.out.println("SetUp Called");
		account = new Bank();
	}
	
	@Test
	public void testInitialBalance() {
		assertEquals(0.0, account.getBalance());
	}
	
	@Test
	public void testDeposit() {
		account.deposit(1000);
		assertEquals(1000, account.getBalance());
	}
	
	@Test
	public void testDepositNegAmt() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(-100);
		});
		assertEquals("Deposit amount must be positive.", exception.getMessage());
	}
	
	@Test
	public void testWithdraw() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(1000);
		});
		assertEquals("Insufficient funds.", exception.getMessage());
	}
	
	@Test
	public void testEmplyAcc()
	{
		account.deposit(100);
		account.withdraw(100);
		assertEquals(0, account.getBalance());
	}
}