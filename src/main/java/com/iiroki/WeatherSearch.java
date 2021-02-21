package com.iiroki;

public class WeatherSearch {
	private WeatherstackClient client_;
	private String current_;
	private boolean searching_;
	
	// Constructor
	public WeatherSearch() {
		client_ = new WeatherstackClient();
		current_ = "Select a city to search weather from.";
		searching_ = false;
	}
	
	public void search(String city, Runnable doneHandler) {
		searching_ = true;
		try {
			String responseStr = client_.get(city);
			//System.out.println(responseStr);
			current_ = responseStr;
			doneHandler.run();
		} catch (Exception e) {
			current_ = e.toString();
		}
	}
	
	public String getCurrent() {
		return current_;
	}
		
	public boolean isSearching() {
		return searching_;
	}
}
