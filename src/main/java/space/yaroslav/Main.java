package space.yaroslav;

import space.yaroslav.apilogic.APIKey;
import space.yaroslav.apilogic.APIRequest;
import com.google.gson.*;
import space.yaroslav.weather.*;

import java.io.IOException;

public class Main {

    private static String[] cities = {"Moscow", "New-York", "Rostov-On-Don", "London", "Paris", "Ottawa", "Ulyanovsk"};

    public static void main(String[] args) throws IOException {

        APIKey key = new APIKey("21e80236d727d4dfc1b5cae33800a000");


        if (args.length == 1) {
            if (args[0].equals("--help")) {
                System.out.println("This is weatherapp. You can set a citykey like -Moscow or any other city in the world, so it will show you current weather.");
                System.out.println("You can type --cities to see a list with some city expamples");
                return;
            }
            if (args[0].equals("--cities")) {
                for (int i = 0; i < cities.length; i++) System.out.println(cities[i]);
                return;
            }
            String httpAnswer = APIRequest.getAPIAnswer(args[0], key, "JSON");
            Gson gson = new Gson();
            WeatherParams weatherParams = gson.fromJson(httpAnswer, WeatherParams.class);
            System.out.println(weatherParams);


        } else System.out.println("There is can be only one argument. Try --help.");



 CurrentWeather currentWeather = new CurrentWeather("21e80236d727d4dfc1b5cae33800a000");
//        //space.yaroslav.Main class tests :)
//        System.out.println(currentWeather.currentWeatherByCityID(1234));
    System.out.println(currentWeather.currentWeatherByCoordinates(12, 54));
//        System.out.println(currentWeather.currentWeatherByZIP(94040, "us"));
//        currentWeather.setResponseMode(ResponseMode.HTML);
//        System.out.println(currentWeather.currentWeatherByCityID(1234));
//        System.out.println(currentWeather.currentWeatherByCoordinates(12, 54));
//        System.out.println(currentWeather.currentWeatherByZIP(94040, "us"));


    }


}

