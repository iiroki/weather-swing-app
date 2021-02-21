package com.iiroki;

public class Weather {
	private String city_;
	private String country_;
	private String region_;
	private int temperature_;
	private String description_;
	private String localTime_;
	
	public Weather() {
		initWeather();
	}
	
	public Weather(String city, String country, String region, int temperature, String description, String localTime) {
		city_ = city;
		country_ = country;
		region_ = region;
		temperature_ = temperature;
		description_ = description;
		localTime_ = localTime;
	}
			
	public String getCity() {
		return city_;
	}
	
	public String getCountry() {
		return country_;
	}
	
	public String getRegion() {
		return region_;
	}
	
	public int getTemperature() {
		return temperature_;
	}
	
	public String getDescription() {
		return description_;
	}
	
	public String getLocalTime() {
		return localTime_;
	}
	
	private void initWeather() {
		city_ = "Test city";
		country_ = "Test county";
		temperature_ = 0;
		description_ = "Test description";
		localTime_ = "Test time";
	}
}
