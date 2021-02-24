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
		mainWindow_.setSearchButtonAction(() -> searchWeather(), () -> sameSearch());
	}
	
	private void searchWeather() {
		// Search weather from input city
		String city = mainWindow_.getSearchValue();
		if (status_.getWeather() != null
				&& city.toLowerCase().equals(status_.getWeather().getCity().toLowerCase())) {
			mainWindow_.updateStatus(status_);
			return;
		}
		mainWindow_.setSearching();
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
	
	private boolean sameSearch() {
		return status_.getWeather() != null
				&& mainWindow_.getSearchValue().toLowerCase().equals(status_.getWeather().getCity().toLowerCase());
	}
}
