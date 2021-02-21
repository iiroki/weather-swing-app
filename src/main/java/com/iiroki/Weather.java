package com.iiroki;

public class Weather {
	private String city_;
	private String country_;
	private String temperature_;
	private String description_;
	private String localTime_;
	
	public Weather() {
		initWeather();
	}
	
	public void setWeather(String city, String country, String temperature, String description, String localTime) {
		city_ = city;
		country_ = country;
		temperature_ = temperature;
		description_ = description;
		localTime_ = localTime;
	}
	
	public Weather getWeather() {
		return this;
	}
	
	public String getCity() {
		return city_;
	}
	
	public String getCountry() {
		return country_;
	}
	
	public String getTemperature() {
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
		temperature_ = "Test temperature";
		description_ = "Test description";
		localTime_ = "Test time";
	}
}
