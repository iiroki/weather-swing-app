package com.iiroki;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow {
	private JFrame mainFrame_;
	private JPanel panel_;
	private JTextField searchInput_;
	private JButton searchButton_;
	private JLabel statusLabel_;
	private JLabel weatherLabel_;	
	
	private static final String NOT_SEARCHED = "Enter a city to search weather from.";
	private static final String SEARCHING = "Searching...";
	private static final String SEARCH_ERROR = "Couldn't retrieve weather data from the wanted city.";

	public MainWindow() {
		mainFrame_ = new JFrame("Weather Swing App");
		panel_ = new JPanel();
		searchInput_ = new JTextField();
		searchButton_ = new JButton("Search");
		statusLabel_ = new JLabel(NOT_SEARCHED, SwingConstants.CENTER);
		weatherLabel_ = new JLabel("", SwingConstants.CENTER);
		
		mainFrame_.setSize(650, 450);
		mainFrame_.setResizable(false);
		initWindow();
		mainFrame_.add(panel_);
	}
	
	public void show() {
		mainFrame_.setVisible(true);
	}
	
	public String getSearchValue() {
		return searchInput_.getText();
	}
	
	public void setSearchButtonAction(Runnable action) {
		ActionListener searchAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// Update GUI first
						setSearching();
						SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
							// Do the wanted action in the background!
							@Override
							protected Void doInBackground() {
                                action.run();
                                return null;
                            }
						};
						worker.execute();
					}
				});
			}
		};
		
		searchButton_.addActionListener(searchAction);
	}
	
	public void setSearching() {
		clearWeather();
		statusLabel_.setText(SEARCHING);
	}
	
	public void updateStatus(WeatherStatus ws) {
		if (!ws.getSearched()) {
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
		
	private void initWindow() {
		// Some constants for component placement
		final int MID = mainFrame_.getWidth() / 2;
		final int CELL_HEIGHT = 40;
		final int GAP = 20;

		panel_.setLayout(null); // Layout

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
		panel_.add(searchInput_);
		panel_.add(searchButton_);
		panel_.add(statusLabel_);
		panel_.add(weatherLabel_);
	}
}
