package com.iiroki;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherStatusTest {

	@Test
	public void testInit() {
		WeatherStatus status = new WeatherStatus();
		assertTrue(status.getWeather() == null);
		assertFalse(status.hasSearched());
		assertFalse(status.getSuccess());
	}
	
	@Test
	public void testSetValidWeather() {
		WeatherStatus status = new WeatherStatus();
		status.setWeather(new Weather("Test", "Test", "Test", 0, 0, "Test", "Test"));
		assertFalse(status.getWeather() == null);
		assertTrue(status.hasSearched());
		assertTrue(status.getSuccess());
	}
	
	@Test
	public void testSetInvalidWeather() {
		WeatherStatus status = new WeatherStatus();
		status.setWeather(null);
		assertTrue(status.getWeather() == null);
		assertTrue(status.hasSearched());
		assertFalse(status.getSuccess());
	}
	
	@Test
	public void testResetWeather() {
		WeatherStatus status = new WeatherStatus();
		status.setWeather(new Weather("Test", "Test", "Test", 0, 0, "Test", "Test"));
		assertFalse(status.getWeather() == null);
		assertTrue(status.hasSearched());
		assertTrue(status.getSuccess());
		status.resetWeather();
		assertTrue(status.getWeather() == null);
		assertFalse(status.hasSearched());
		assertFalse(status.getSuccess());
	}

}
