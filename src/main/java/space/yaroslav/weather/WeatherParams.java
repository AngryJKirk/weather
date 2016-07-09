package space.yaroslav.weather;


import java.util.ArrayList;
import java.util.List;

public class WeatherParams {
//TODO add getters for inner classes
    private List<Weather> weather = new ArrayList<Weather>();

    private MainInfo main;

    private Wind wind;

    private String name;

    private int cod;

    public int getCod() {
        return cod;
    }



    public List<Weather> getWeather() {
        return weather;
    }

    public MainInfo getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (cod == 404) return "There are no such city. Try again.";

        if (cod == 401) return "Your API-key is invalid";

        return String.format("In %s there is/are %s. Temperature is %f, pressure is %f, humidity is %f, wind's speed is %f", name, weather.get(0).getDescription(), main.getTemp() - 273, main.getPressure(), main.getHumidity(), wind.getSpeed());
    }
}


class Wind {


    private float speed;

    public float getSpeed() {
        return speed;
    }


}


class MainInfo {


    private float temp;

    private float pressure;

    private float humidity;

    public float getPressure() {
        return pressure;
    }


    public float getHumidity() {
        return humidity;
    }


    public float getTemp() {
        return temp;
    }
}


class Weather {

    private String main;

    private String description;

    public String getMain() {
        return main;
    }


    public String getDescription() {
        return description;
    }

}


