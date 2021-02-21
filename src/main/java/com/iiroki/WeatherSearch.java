package com.iiroki;

public class WeatherSearch {
	private WeatherstackClient client_;
	
	// Constructor
	public WeatherSearch() {
		client_ = new WeatherstackClient();
	}
	
	public String search(String city) {
		try {
			String responseStr = client_.get(city);
			return responseStr;
		} catch (Exception e) {
			return e.toString();
		}
	}
}
