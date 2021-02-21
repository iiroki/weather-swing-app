package com.iiroki;

public class AppEngine {
	private WeatherStatus weather_;
	private MainWindow mainWindow_;
	private WeatherSearch searchClient_;
	
	public AppEngine(WeatherStatus ws, MainWindow mw) {
		weather_ = ws;
		mainWindow_ = mw;
		searchClient_ = new WeatherSearch();
		
	}
	
	public void initController() {
		mainWindow_.getSearchButton().addActionListener(e -> searchWeather());
	}
	
	private void searchWeather() {
		// Search weather from input city
		String city = mainWindow_.getSearchInput().getText();
		weather_.setWeather(searchClient_.search(city));
		// Update weather in view
		mainWindow_.updateStatus(weather_);
		if (weather_.hasSearched()) {
			mainWindow_.updateWeather(weather_.getWeather());
		}
	}
}
