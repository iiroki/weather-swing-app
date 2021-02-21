package com.iiroki;

public class WeatherSwingApp {
	public static void main(String[] args) {
		Weather w = new Weather();
		MainWindow mw = new MainWindow();
		AppEngine e = new AppEngine(w, mw);
		e.initController();
		mw.show();
	}
}
