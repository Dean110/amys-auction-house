package com.amysauctionhouse;

import org.apache.commons.validator.routines.EmailValidator;

public class Buyer {
	private String name;
	private String userName;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if (isValidUserName(userName)) {
			this.userName = userName;
		}else {
			throw new InvalidUserNameException("Invalid email address: "+ userName);
		}
	}

	private boolean isValidUserName(String userName) {
		return EmailValidator.getInstance().isValid(userName);
	}
}
