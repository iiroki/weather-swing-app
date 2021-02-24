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
		mainWindow_.setSearchButtonAction(() -> searchWeather());
	}
	
	private void searchWeather() {
		mainWindow_.setSearching();
		// Search weather from input city
		String city = mainWindow_.getSearchValue();
		if (city.isEmpty()) {
			status_.resetWeather();
		} else {
			status_.setWeather(searchClient_.search(city));
		}
		// Update weather in view
		mainWindow_.updateStatus(status_);
		if (status_.getSearched() && status_.getSuccess()) {
			mainWindow_.updateWeather(status_.getWeather());
		}
	}
}
