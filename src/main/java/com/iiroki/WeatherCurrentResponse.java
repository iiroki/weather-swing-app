package com.iiroki;

import com.google.gson.annotations.SerializedName;

public class WeatherCurrentResponse {
	@SerializedName("request")
	private ResponseRequest request;
	private ResponseLocation location;
	private ResponseCurrent current;
	
	public Weather getWeather() {
		return new Weather(
				location.getName(),
				location.getCountry(),
				location.getRegion(),
				current.getTemp(),
				current.getDescription(),
				location.getLocalTime()
				);
	}
	
	public String getCity() {
		return location.getName();
	}
	
	public String getCountry() {
		return location.getCountry();
	}

	public int getTemp() {
		return current.getTemp();
	}
	
	public String getDescription() {
		return current.getDescription();
	}

	private class ResponseRequest {
		//private String type;
		//private String query;
		//private String language;
		//private String unit;
	}

	private class ResponseLocation {
		private String name;
		private String country;
		private String region;
		//private String lat;
		//private String lon;
		//private String timezone_id;
		private String localtime;
		//private String localtime_epoch;
		//private String utf_offset;
		
		public String getName() {
			return name;
		}
		
		public String getCountry() {
			return country;
		}
		
		public String getRegion() {
			return region;
		}
		
		public String getLocalTime() {
			return localtime;
		}
	}

	private class ResponseCurrent {
		////private String observation_time;
		private int temperature;
		private String[] weather_descriptions;
		
		public int getTemp() {
			return temperature;
		}
		
		public String getDescription() {
			return weather_descriptions[0];
		}
	}
}
	