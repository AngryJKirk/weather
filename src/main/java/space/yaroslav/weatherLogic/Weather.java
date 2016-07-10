package space.yaroslav.weatherLogic;

import space.yaroslav.pojos.ResponseMode;
import space.yaroslav.pojos.WeatherParams;

import java.io.IOException;

public interface Weather {


    void setKey(String key);

    WeatherParams currentWeatherByCityName(String city) throws IOException;

    WeatherParams currentWeatherByCityID(int id);

    WeatherParams currentWeatherByZIP(int zip, String countryCode);

    WeatherParams currentWeatherByCoordinates(int lat, int lon);

    void setResponseMode(ResponseMode responseMode);

}
