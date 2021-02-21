package com.iiroki;

public class AppEngine {
	private Weather weather_;
	private MainWindow mainWindow_;
	private WeatherSearch searchClient_;
	
	public AppEngine(Weather w, MainWindow mw) {
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
		weather_ = searchClient_.search(city);
		// Update weather in view
		mainWindow_.updateWeather(weather_);
	}
}
