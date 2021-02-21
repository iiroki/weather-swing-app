package com.iiroki;

import java.io.IOException;
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
	
	public String get(String city) throws Exception {
		String url = getRequestUrl(city);
		
		// Make the HTTP request
		Future<String> whenResponse = httpClient_.prepareGet(url).execute(new AsyncCompletionHandler<String>() {
			@Override
			public String onCompleted(Response response) throws IOException {
				return response.getResponseBody();
			}
		});
		
		return whenResponse.get();
	}
	
	private String getRequestUrl(String city) {
		return baseUrl_ + "?access_key=" + apiKey_ + "&query=" + city;
	}
}
