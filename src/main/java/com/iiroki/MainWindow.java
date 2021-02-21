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

	public MainWindow() {
		mainFrame_ = new JFrame("Weather Swing App");
		searchInput_ = new JTextField();
		searchButton_ = new JButton("Search");
		statusLabel_ = new JLabel(NOT_SEARCHED);
		weatherLabel_ = new JLabel();
		
		JPanel panel = new JPanel();
		mainFrame_.add(panel);
		initWindow(panel);
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

		String status = "<html>" + "Showing weather in: " + ws.getWeather().getCity() + "<br>(" + ws.getWeather().getRegion() + ", " + ws.getWeather().getCountry() + ")</html>";
		statusLabel_.setText(status);
	}
	
	public void updateWeather(Weather weather) {
		// TODO: All information
		weatherLabel_.setText(weather.getTemperature() + " " + "\u00B0" + "C");
	}
	
	private void clearWeather() {
		weatherLabel_.setText("");
	}
		
	private void initWindow(JPanel panel) {
		// Main frame
		mainFrame_.setSize(800, 600);
		mainFrame_.setLocationRelativeTo(null);
		mainFrame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// City search input
		searchInput_.setPreferredSize(new Dimension(200, 40));
		Font inputFont = new Font("SansSerif", Font.PLAIN, 20);
		searchInput_.setFont(inputFont);
		searchInput_.setHorizontalAlignment(JTextField.CENTER);
		
		// Search button
		searchButton_.setSize(80, 40);
		Font buttonFont = new Font("SansSerif", Font.PLAIN, 20);
		searchButton_.setFont(buttonFont);
		
		// Status
		statusLabel_.setSize(100, 20);
		
		// Weather
		weatherLabel_.setSize(400, 200);
		
		panel.add(searchInput_);
		panel.add(searchButton_);
		panel.add(statusLabel_);
		panel.add(weatherLabel_);
	}
}
