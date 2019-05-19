package com.amysauctionhouse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Buyer {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

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
		} else {
			this.userName = "";
		}
	}

	private boolean isValidUserName(String userName) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(userName);
		return matcher.find();
	}
}
