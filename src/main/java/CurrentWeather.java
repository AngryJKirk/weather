import APILogic.APIKey;
import APILogic.APIRequest;
import com.google.gson.Gson;
import java.io.IOException;


enum ResponseMode {
    JSON, XML, HTTP
}
class CurrentWeather implements IWeather {

    private APIKey apiKey;

    private ResponseMode responseMode = ResponseMode.JSON;

    CurrentWeather(String key){
        this.setKey(key);
    }

    public void setKey(String key) {
        this.apiKey = new APIKey(key);
    }



    public WeatherParams currentWeatherByCityName(String city) throws IOException {

        String answer = APIRequest.getAPIAnswer(city, apiKey, responseMode.toString());
        Gson gson = new Gson();
        return gson.fromJson(answer, WeatherParams.class);
    }

    public WeatherParams currentWeatherByCityID(int id) {
        String answer = APIRequest.getAPIAnswer(id, apiKey, responseMode.toString());
        Gson gson = new Gson();
        return gson.fromJson(answer, WeatherParams.class);
    }

    public WeatherParams currentWeatherByZIP(int zip, String countryCode) {

        String answer = APIRequest.getAPIAnswer(zip, countryCode, apiKey, responseMode.toString());
        Gson gson = new Gson();
        return gson.fromJson(answer, WeatherParams.class);

    }

    public WeatherParams currentWeatherByCoordinates(int lat, int lon) {
        String answer = APIRequest.getAPIAnswer(lat, lon, apiKey, responseMode.toString());
        Gson gson = new Gson();
        return gson.fromJson(answer, WeatherParams.class);
    }

    public void setResponseMode(ResponseMode responseMode) {
        this.responseMode = responseMode;
    }
}
