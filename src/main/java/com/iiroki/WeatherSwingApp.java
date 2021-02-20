package com.iiroki;

import javax.swing.*;

public class WeatherSwingApp {
	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("Weather Swing App");
		mainWindow.setSize(800, 600);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
