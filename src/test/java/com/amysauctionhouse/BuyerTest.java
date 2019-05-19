package com.amysauctionhouse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BuyerTest {

	@Test
	public void buyerShouldHaveAName() {
		Buyer underTest = new Buyer();
		underTest.setName("Joe Tester");
		
		String buyerName = underTest.getName();
		
		assertEquals( "Joe Tester", buyerName, "Names should match.");
	}
	
	
}
