package com.iiroki;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WeatherSwingApp {	
	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("Weather Swing App");
		mainWindow.setSize(800, 600);
		mainWindow.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		mainWindow.add(panel);
		addComponents(panel);
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}
	
	private static void addComponents(JPanel panel) {
		// Text field for search searchInput
		JTextField searchInput = new JTextField();
		searchInput.setPreferredSize(new Dimension(200, 40));
		Font inputFont = new Font("SansSerif", Font.PLAIN, 20);
		searchInput.setFont(inputFont);
		searchInput.setHorizontalAlignment(JTextField.CENTER);
		panel.add(searchInput);
		
		// Button for firing a search
		JButton searchButton = new JButton("Hae");
		searchButton.setSize(80, 40);
		Font buttonFont = new Font("SansSerif", Font.PLAIN, 20);
		searchButton.setFont(buttonFont);
		
		// Button action
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Weather from: \"" + searchInput.getText() + "\"");
			}
		});
		
		panel.add(searchButton);
	}
}
