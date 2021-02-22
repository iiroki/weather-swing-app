package com.iiroki;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherSearchTest {

	@Test
	public void testValidSearch() {
		String city = "Tampere";
		WeatherSearch client = new WeatherSearch();
		Weather response = client.search(city);
		assertEquals(response.getCity(), city);
	}
	
	@Test
	public void testInvalidSearch() {
		String city = "Imaginarycity";
		WeatherSearch client = new WeatherSearch();
		Weather response = client.search(city);
		assertTrue(response == null);
	}

}
