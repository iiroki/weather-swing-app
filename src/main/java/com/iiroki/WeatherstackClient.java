package com.iiroki;

import io.github.cdimascio.dotenv.Dotenv;

public class WeatherstackClient {
	private String baseUrl_;
	private String apiKey_;
	
	public WeatherstackClient() {
		baseUrl_ = "http://api.weatherstack.com/current/"; // API endpoint
		Dotenv dotenv = Dotenv.load();
		apiKey_ = dotenv.get("API_KEY");
	}
	
	public void get(String city) {
		String url = getRequestUrl(city);
		System.out.println("GET: " + url);
	}
	
	private String getRequestUrl(String city) {
		return baseUrl_ + "?access_key=" + apiKey_ + "&query=" + city;
	}
}
