package com.iiroki;

public class AppEngine {
	private Weather weather_;
	private MainWindow mainWindow_;
	private WeatherSearch searchClient_;
	
	private String testWeather_;
	
	public AppEngine(Weather w, MainWindow mw) {
		// For testing!
		testWeather_ = "";

		weather_ = w;
		mainWindow_ = mw;
		searchClient_ = new WeatherSearch();
	}
	
	public void initController() {
		mainWindow_.getSearchButton().addActionListener(e -> searchWeather());
	}
	
	private void searchWeather() {
		// Search weather from input city
		String city = mainWindow_.getSearchInput().getText();
		testWeather_ = searchClient_.search(city);
		System.out.println(testWeather_);
		weather_.setWeather(city, "Unknown", "15", "Unknown", "00:00");
		// Update weather in view
		mainWindow_.updateWeather(weather_);
	}
}
