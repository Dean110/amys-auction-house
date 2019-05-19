package com.amysauctionhouse;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
		assertAll("One or more of the names were not set correctly.", () -> assertNameSetting("Joe Tester"),
				() -> assertNameSetting("Jane Tester"));
	}

	@Test
	@DisplayName("Getter and Setter Test for Buyer UserName.")
	public void buyerShouldHaveAnUserName() {
		assertAll("One or more of the userNames were not set correctly.", () -> assertUserNameIsSet("test@testing.com"),
				() -> assertUserNameIsSet("testing@tester.com"));
	}

	@Test
	@DisplayName("New userNames should be a valid email address.")
	public void newUserNamesShouldBeValidEmailAddresses() {
		underTest.setUserName("test@testing.com");
		assertAll(() -> assertInvalidUserNameIsNotSet("BOBBY B", "test@testing.com"),
				() -> assertInvalidUserNameIsNotSet("BOBBY B@KL.COM", "test@testing.com"),
				() -> assertInvalidUserNameIsNotSet("Bobby B <bobs@kl.com>", "test@testing.com"),
				() -> assertInvalidUserNameIsNotSet("BOBBY_B@kl.com!", "test@testing.com"));
	}

	@Test
	public void tryingToChangeAnUserNameToAnInvalidNameThrowsAnException() {
		InvalidUserNameException thrownException = assertThrows(InvalidUserNameException.class,
				() -> underTest.setUserName("BOBBY B"), "Expected setUserName() to throw, but it did not.");
		assertTrue(thrownException.getMessage().contains("Invalid email address: " + "BOBBY B"));
	}

	private void assertInvalidUserNameIsNotSet(String givenUserName, String expectedUserName) {
		try {
			underTest.setUserName(givenUserName);
			fail("Expected exception not thrown.");
		} catch (InvalidUserNameException e) {
			assertTrue(e.getMessage().contains("Invalid email address: " + givenUserName), 
					"Thrown exception did not contain expected message");
		}
		String buyerUserName = underTest.getUserName();
		assertEquals(expectedUserName, buyerUserName, "UserNames should match.");
	}

	private void assertUserNameIsSet(String givenUserName) {
		underTest.setUserName(givenUserName);

		String buyerUserName = underTest.getUserName();

		assertEquals(givenUserName, buyerUserName, "UserNames should match.");
	}

	private void assertNameSetting(String givenName) {
		underTest.setName(givenName);

		String buyerName = underTest.getName();

		assertEquals(givenName, buyerName, "Names should match.");
	}

}
