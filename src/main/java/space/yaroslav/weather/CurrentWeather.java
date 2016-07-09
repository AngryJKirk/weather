package space.yaroslav.weather;

import space.yaroslav.API.APIKey;
import com.google.gson.Gson;
import space.yaroslav.pojos.ResponseMode;
import space.yaroslav.pojos.WeatherParams;

import java.io.IOException;

import static space.yaroslav.API.APIRequest.*;


/**
 * This class is a class-wrap with API for http://openweathermap.org/
 * To use this you have to set an API key. Its avaliable free on their site.
 */
public class CurrentWeather implements Weathers {

    private APIKey apiKey;
    private Gson gson = new Gson();
    private ResponseMode responseMode = ResponseMode.JSON;

    public CurrentWeather(String key) {
        this.setKey(key);
    }

    public void setKey(String key) {
        this.apiKey = new APIKey(key);
    }


    /**
     * @param city City wheather's you want to know
     * @return WeatherParams is POJO with important fields with weather params
     */
    public WeatherParams currentWeatherByCityName(String city) throws IOException {

        String answer = getAPIAnswerByCityName(city, apiKey, responseMode.toString());

        return gson.fromJson(answer, WeatherParams.class);
    }

    /**
     * @param id City id from http://bulk.openweathermap.org/sample/
     * @return WeatherParams is POJO with important fields with weather params
     */
    public WeatherParams currentWeatherByCityID(int id) {
        String answer = getAPIAnswerByCityID(id, apiKey, responseMode.toString());

        return gson.fromJson(answer, WeatherParams.class);
    }

    /**
     * @param zip         zip code of city you need
     * @param countryCode country cod from ISO 3166 standart
     * @return WeatherParams is POJO with important fields with weather params
     */
    public WeatherParams currentWeatherByZIP(int zip, String countryCode) {

        String answer = getAPIAnswerByZipCode(zip, countryCode, apiKey, responseMode.toString());

        return gson.fromJson(answer, WeatherParams.class);

    }

    /**
     * @param lat Latitude of place's weather you need
     * @param lon Longitude of place's weather you need
     * @return WeatherParams is POJO with important fields with weather params
     */
    public WeatherParams currentWeatherByCoordinates(int lat, int lon) {
        String answer = getAPIAnswerByCoordinates(lat, lon, apiKey, responseMode.toString());

        return gson.fromJson(answer, WeatherParams.class);
    }

    /**
     * @param responseMode contains part of API request, make responce of API request returning different type of information, like XML or HTML. JSON is default type.
     *                     Dont change it, methods with HTML/XML parsing is not released now.
     */
    public void setResponseMode(ResponseMode responseMode) {
        this.responseMode = responseMode;
    }
}
