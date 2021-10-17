package com.java.liscence;

public class IdNotFoundException extends Exception {
	public String getMessage() {
		return "Gevernment Id is required to take the driving liscence";
	}

}
