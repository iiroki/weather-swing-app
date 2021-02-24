package com.iiroki;

public class WeatherStatus {
	private boolean searched_;
	private Weather weather_;
	private boolean success_;
	
	public WeatherStatus() {
		searched_ = false;
		weather_ = null;
		success_ = false;
	}
	
	public boolean getSearched() {
		return searched_;
	}
	
	public Weather getWeather() {
		return weather_;
	}
	
	public boolean getSuccess() {
		return success_;
	}
		
	public void setWeather(Weather w) {
		if (w == null) {
			success_ = false;
		} else {
			success_ = true;
		}

		searched_ = true;
		weather_ = w;
	}
	
	public void resetWeather() {
		weather_ = null;
		searched_ = false;
		success_ = false;
	}
}
