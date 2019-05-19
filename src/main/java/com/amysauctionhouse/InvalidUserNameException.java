package com.amysauctionhouse;

@SuppressWarnings("serial")
public class InvalidUserNameException extends RuntimeException{

	public InvalidUserNameException(String message) {
		super(message);
	}

}
