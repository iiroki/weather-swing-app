package com.iiroki;

public class WeatherSearch {
	private WeatherstackClient client_;
	private String city_;
	private boolean searching_;
	
	// Constructor
	public WeatherSearch() {
		client_ = new WeatherstackClient();
		city_ = "";
		searching_ = false;
	}
	
	public void setSearch(String city) {
		city_ = city;
		searching_ = true;
		client_.get(city_);
	}
	
	public String getSearch() {
		return city_;
	}
	
	public boolean isSearching() {
		return searching_;
	}
}
