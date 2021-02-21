package com.iiroki;

public class WeatherSwingApp {
	public static void main(String[] args) {
		// MVC
		Weather w = new Weather(); // Model
		MainWindow mw = new MainWindow(); // View
		AppEngine e = new AppEngine(w, mw); // Controller
		e.initController();
		mw.show();
	}
}
