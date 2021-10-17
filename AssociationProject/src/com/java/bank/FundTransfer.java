package com.java.bank;

public class FundTransfer{
	void fundsTransferService(WithdrawService src,DepositService trg) {
		System.out.println("Transferring funds...");
		src.withdraw();
		trg.deposite();
		System.out.println("Transfer successful");
	}
}

interface WithdrawService{
	void withdraw();
}

interface DepositService{
	void deposite();
}

class SavingsAccount implements WithdrawService,DepositService{
	public void withdraw() {
		System.out.println("withdraw...");
	}
	
	public void deposite() {
		System.out.println("deposite....");
	}
}
