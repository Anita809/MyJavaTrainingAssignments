package com.java.bankException;

	public class InvalidOpeningBalanceException extends Exception {
		InvalidOpeningBalanceException(String str) {
			super(str);
		}
}
