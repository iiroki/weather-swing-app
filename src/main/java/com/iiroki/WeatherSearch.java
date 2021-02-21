package com.iiroki;

public class WeatherSearch {
	private WeatherstackClient client_;
	private boolean searching_;
	
	// Constructor
	public WeatherSearch() {
		client_ = new WeatherstackClient();
		searching_ = false;
	}
	
	public String search(String city) {
		searching_ = true;
		try {
			String responseStr = client_.get(city);
			return responseStr;
		} catch (Exception e) {
			return e.toString();
		}
	}
			
	public boolean isSearching() {
		return searching_;
	}
}
