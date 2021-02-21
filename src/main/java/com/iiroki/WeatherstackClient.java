package com.iiroki;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.asynchttpclient.*;
import io.github.cdimascio.dotenv.Dotenv;

public class WeatherstackClient {
	private String baseUrl_;
	private String apiKey_;
	private AsyncHttpClient httpClient_;
	
	public WeatherstackClient() {
		baseUrl_ = "http://api.weatherstack.com/current"; // API endpoint
		Dotenv dotenv = Dotenv.load();
		apiKey_ = dotenv.get("API_KEY");
		httpClient_ = Dsl.asyncHttpClient();
	}
	
	public void get(String city) {
		String url = getRequestUrl(city);
		System.out.println("GET: " + url);
		
		// Make the HTTP request
		Future<Integer> whenResponse = httpClient_.prepareGet(url).execute(new AsyncCompletionHandler<Integer>() {
			@Override
			public Integer onCompleted(Response response) throws IOException {
				return response.getStatusCode();
			}
		});
		
		try {
			Integer status = whenResponse.get();
			System.out.println("HTTP Status: " + status);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getRequestUrl(String city) {
		return baseUrl_ + "?access_key=" + apiKey_ + "&query=" + city;
	}
}
