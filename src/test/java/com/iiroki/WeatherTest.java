package com.iiroki;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherTest {

	@Test
	public void testWeather() {
		String city = "Test city";
		String country = "Test country";
		String region = "Test region";
		int temperature = 0;
		int windSpeed = 0;
		String description = "Test description";
		String localTime = "YYYY-MM-DD HH:MM";
		Weather w = new Weather(city, country, region, temperature, windSpeed, description, localTime);

		assertEquals(w.getCity(), city);
		assertEquals(w.getCountry(), country);
		assertEquals(w.getRegion(), region);
		assertEquals(w.getTemperature(), temperature);
		assertEquals(w.getWindSpeed(), windSpeed);
		assertEquals(w.getDescription(), description);
		assertEquals(w.getLocalTime(), localTime);
	}

}
