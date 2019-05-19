package com.amysauctionhouse;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {

	Buyer underTest;

	@BeforeEach
	public void setupForEach() {
		underTest = new Buyer();
	}

	@Test
	@DisplayName("Getter and Setter Test for Buyer Name.")
	public void buyerShouldHaveAName() {
		assertAll("One or more of the names were not set correctly.", 
			() -> assertNameSetting("Joe Tester"),
			() -> assertNameSetting("Jane Tester")
		);
	}

	@Test
	@DisplayName("Getter and Setter Test for Buyer UserName.")
	public void buyerShouldHaveAnUserName() {
		assertAll("One or more of the userNames were not set correctly.",
		    () -> assertUserNameIsSet("test@testing.com"),
		    () -> assertUserNameIsSet("testing@tester.com")
		);
	}

	@Test
	@DisplayName("UserName should be a valid email address.")
	public void newUserNamesShouldBeValidEmailAddresses() {
		assertAll(
			()->assertUserNameIsSet("BOBBY B", ""),
			()->assertUserNameIsSet("BOBBY B@KL.COM", ""),
			()->assertUserNameIsSet("Bobby B <bobs@kl.com>", ""),
			()->assertUserNameIsSet("BOBBY_B@kl.com!", "")
		);
	}	
	
	private void assertUserNameIsSet(String givenUserName, String expectedUserName) {
		underTest.setUserName(givenUserName);
		
		String buyerUserName= underTest.getUserName();
		
		assertEquals(expectedUserName, buyerUserName, "UserNames should match.");
	}

	private void assertUserNameIsSet(String givenUserName) {
		underTest.setUserName(givenUserName);
		
		String buyerUserName= underTest.getUserName();
		
		assertEquals(givenUserName, buyerUserName, "UserNames should match.");
	}
	
	
	private void assertNameSetting(String givenName) {
		underTest.setName(givenName);

		String buyerName = underTest.getName();

		assertEquals(givenName, buyerName, "Names should match.");
	}

}
