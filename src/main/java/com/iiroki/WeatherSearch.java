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
			return null;
		}
	}
	
	private Weather parseResponse(String response) {
		String success = response.substring(11, 16);
		if (success == "false") {
			System.out.println("Error!");
			return null;
		}
		WeatherCurrentResponse parsedWeather = parser_.fromJson(response, WeatherCurrentResponse.class);
		return parsedWeather.getWeather();
	}
}
