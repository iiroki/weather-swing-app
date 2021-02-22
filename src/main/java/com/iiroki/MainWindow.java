package com.iiroki;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class MainWindow {
	private JFrame mainFrame_;
	private JTextField searchInput_;
	private JButton searchButton_;
	private JLabel statusLabel_;
	private JLabel weatherLabel_;	
	
	public static final String NOT_SEARCHED = "Enter a city to search weather from.";
	public static final String SEARCH_ERROR = "Couldn't retrieve weather data from the wanted city.";

	public MainWindow() {
		mainFrame_ = new JFrame("Weather Swing App");
		searchInput_ = new JTextField();
		searchButton_ = new JButton("Search");
		statusLabel_ = new JLabel(NOT_SEARCHED, SwingConstants.CENTER);
		weatherLabel_ = new JLabel("", SwingConstants.CENTER);
		
		mainFrame_.setSize(650, 450);
		mainFrame_.setResizable(false);
		JPanel panel = new JPanel();
		initWindow(panel);
		mainFrame_.add(panel);
	}
	
	public void show() {
		mainFrame_.setVisible(true);
	}
	
	public JTextField getSearchInput() {
		return searchInput_;
	}
	
	public JButton getSearchButton() {
		return searchButton_;
	}
	
	public void updateStatus(WeatherStatus ws) {
		if (!ws.hasSearched()) {
			statusLabel_.setText(NOT_SEARCHED);
			clearWeather();
			return;
		}
		
		if (!ws.getSuccess()) {
			statusLabel_.setText(SEARCH_ERROR);
			clearWeather();
			return;
		}

		String statusStr = "<html><div style='text-align: center;'>"
				+ "Showing weather in:<br><b>" + ws.getWeather().getCity() + "</b>"
				+ "<br>(" + ws.getWeather().getRegion() + ", " + ws.getWeather().getCountry()
				+ ")</div></html>";
		statusLabel_.setText(statusStr);
	}
	
	public void updateWeather(Weather weather) {
		String weatherStr = "<html><div style='text-align: center;'>"
				+ "Temperature: " + weather.getTemperature() + " " + "\u00B0" + "C<br>"
				+ "Wind speed: " + weather.getWindSpeed() + " km/h<br>"
				+ "Description: " + weather.getDescription() + "<br>"
				+ "Local time: " + weather.getLocalTime()
				+ "</div></html>";
		weatherLabel_.setText(weatherStr);
	}
	
	private void clearWeather() {
		weatherLabel_.setText("");
	}
		
	private void initWindow(JPanel panel) {
		// Some constants for component placement
		final int MID = mainFrame_.getWidth() / 2;
		final int CELL_HEIGHT = 40;
		final int GAP = 20;

		panel.setLayout(null); // Layout

		// Main frame
		mainFrame_.setLocationRelativeTo(null);
		mainFrame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Sizes
		Dimension searchInputSize = new Dimension(240, CELL_HEIGHT);
		Dimension searchButtonSize = new Dimension(120, CELL_HEIGHT);
		Dimension statusLabelSize = new Dimension(mainFrame_.getWidth(), 100);
		Dimension weatherLabelSize = new Dimension(mainFrame_.getWidth(), 200);
		
		// Bounds
		searchInput_.setBounds(MID - (searchInputSize.width/2), 10, searchInputSize.width, searchInputSize.height);
		searchButton_.setBounds(MID - (searchButtonSize.width/2), CELL_HEIGHT + GAP, searchButtonSize.width, searchButtonSize.height);
		statusLabel_.setBounds(MID - (statusLabelSize.width/2), 2 * (CELL_HEIGHT + GAP), statusLabelSize.width, statusLabelSize.height);
		weatherLabel_.setBounds(MID - (weatherLabelSize.width/2), 3 * (CELL_HEIGHT + GAP), weatherLabelSize.width, weatherLabelSize.height);
		
		// Search input style
		Font inputFont = new Font("SansSerif", Font.PLAIN, 20);
		searchInput_.setFont(inputFont);
		searchInput_.setHorizontalAlignment(JTextField.CENTER);
		
		// Search button style
		Font buttonFont = new Font("SansSerif", Font.PLAIN, 20);
		searchButton_.setFont(buttonFont);
		
		// Status style
		Font statusFont = new Font("SansSerif", Font.PLAIN, 22);
		statusLabel_.setFont(statusFont);
		
		// Weather style
		Font weatherFont = new Font("SansSerif", Font.PLAIN, 20);
		weatherLabel_.setFont(weatherFont);
		
		// Add components to the panel
		panel.add(searchInput_);
		panel.add(searchButton_);
		panel.add(statusLabel_);
		panel.add(weatherLabel_);
	}
}
