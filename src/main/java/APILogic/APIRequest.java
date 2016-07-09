package APILogic;

import APILogic.APIKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class APIRequest {
    private static final String ApiURL = "http://api.openweathermap.org/data/2.5/weather?";

    public static String getAPIAnswer(String city, APIKey key, String mode) throws IOException {
        StringBuilder URL = new StringBuilder(ApiURL);
        return getHttpAnswer(URL
                .append(String.format("q=%s", city))
                .append(String.format("&appid=%s", key.getKey()))
                .append(String.format("&mode=%s", mode))
                .toString());

    }

    public static String getAPIAnswer(int id, APIKey key, String mode) {
        StringBuilder URL = new StringBuilder(ApiURL);
        return getHttpAnswer(URL.
                append(String.format("id=%d", id))
                .append(String.format("&appid=%s", key.getKey()))
                .append(String.format("&mode=%s", mode))
                .toString());
    }

    public static String getAPIAnswer(int zip, String countryCode, APIKey key, String mode) {
        StringBuilder URL = new StringBuilder(ApiURL);
        return getHttpAnswer(URL
                .append(String.format("zip=%d", zip))
                .append(String.format(",%s", countryCode))
                .append(String.format("&appid=%s", key.getKey()))
                .append(String.format("&mode=%s", mode))
                .toString());

    }

    public static String getAPIAnswer(int lat, int lon, APIKey key, String mode) {
        StringBuilder URL = new StringBuilder(ApiURL);
        return getHttpAnswer(URL
                .append(String.format("lat=%d", lat))
                .append(String.format("&lon=%d", lon))
                .append(String.format("&appid=%s", key.getKey()))
                .append(String.format("&mode=%s", mode))
                .toString());
    }

    private static String getHttpAnswer(String url) {
        URL api = null;
        //TODO handle exceptions in a right way
        try {
            api = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        BufferedReader in = null;
        try {
            connection = api.openConnection();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}


