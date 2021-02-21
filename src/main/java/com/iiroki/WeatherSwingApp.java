package com.iiroki;

public class WeatherSwingApp {
	public static void main(String[] args) {
		// MVC
		WeatherStatus ws = new WeatherStatus(); // Model
		MainWindow mw = new MainWindow(); // View
		AppEngine e = new AppEngine(ws, mw); // Controller
		e.initController();
		mw.show();
	}
}
