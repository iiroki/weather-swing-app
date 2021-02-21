package com.iiroki;

public class WeatherStatus {
	private boolean searched_;
	private Weather weather_;
	
	public WeatherStatus() {
		searched_ = false;
		weather_ = null;
	}
	
	public boolean hasSearched() {
		return searched_;
	}
	
	public Weather getWeather() {
		return weather_;
	}
	
	public void setWeather(Weather w) {
		if (w == null) {
			searched_ = false;
		} else {
			searched_ = true;
		}

		weather_ = w;
	}
	
	public void resetWeather() {
		weather_ = null;
		searched_ = false;
	}
}
