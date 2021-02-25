package com.iiroki;

import com.google.gson.annotations.SerializedName;

public class WeatherCurrentResponse {
    @SerializedName("request")
    private ResponseRequest request;
    private ResponseLocation location;
    private ResponseCurrent current;

    public Weather getWeather() {
        return new Weather(location.getName(),
                location.getCountry(),
                location.getRegion(),
                current.getTemperature(),
                current.getWindSpeed(),
                current.getDescription(),
                location.getLocalTime());
    }

    private class ResponseRequest {
        // private String type;
        // private String query;
        // private String language;
        // private String unit;
    }

    private class ResponseLocation {
        private String name;
        private String country;
        private String region;
        // private String lat;
        // private String lon;
        // private String timezone_id;
        private String localtime;
        // private String localtime_epoch;
        // private String utf_offset;

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
        // private String observation_time;
        private int temperature;
        // private String weather_code;
        // private String[] weather_icons;
        private String[] weather_descriptions;
        private int wind_speed;
        // private int wind_degree;
        // private String wind_dir;
        // private int pressure;
        // private int precip;
        // private int humidity;
        // private int cloudcover;
        // private int feelslike;
        // private int uv_index;
        // private int visibility;
        // private String is_day;

        public int getTemperature() {
            return temperature;
        }

        public String getDescription() {
            return weather_descriptions[0];
        }

        public int getWindSpeed() {
            return wind_speed;
        }
    }
}
