package com.iiroki;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherSearchTest {

	@Test
	public void setSearch() {
		WeatherSearch ws = new WeatherSearch();
		String city = "Helsinki";
		ws.setSearch(city);
		assertEquals(city, ws.getSearch());
	}

}
