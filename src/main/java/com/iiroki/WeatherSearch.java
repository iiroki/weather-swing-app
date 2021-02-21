package com.iiroki;

import com.google.gson.Gson;

public class WeatherSearch {
	private WeatherstackClient client_;
	private Gson parser_;
		
	// Constructor
	public WeatherSearch() {		
		client_ = new WeatherstackClient();
		parser_ = new Gson();
	}
	
	public Weather search(String city) {
		try {
			String responseStr = client_.get(city);
			return parseResponse(responseStr);
		} catch (Exception e) {
			return new Weather();
		}
	}
	
	private Weather parseResponse(String response) {
		WeatherCurrentResponse parsedWeather = parser_.fromJson(response, WeatherCurrentResponse.class);
		return parsedWeather.getWeather();
	}
}
