package com.iiroki;

public class AppEngine {
	private WeatherStatus status_;
	private MainWindow mainWindow_;
	private WeatherSearch searchClient_;
	
	public AppEngine(WeatherStatus ws, MainWindow mw) {
		status_ = ws;
		mainWindow_ = mw;
		searchClient_ = new WeatherSearch();
		
	}
	
	public void initController() {
		mainWindow_.getSearchButton().addActionListener(e -> searchWeather());
	}
	
	private void searchWeather() {
		// Search weather from input city
		String city = mainWindow_.getSearchInput().getText();
		if (city.isEmpty()) {
			status_.resetWeather();
		} else {
			status_.setWeather(searchClient_.search(city));
		}
		// Update weather in view
		mainWindow_.updateStatus(status_);
		if (status_.hasSearched() && status_.getSuccess()) {
			mainWindow_.updateWeather(status_.getWeather());
		}
	}
}
