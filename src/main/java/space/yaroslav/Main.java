package space.yaroslav;


import space.yaroslav.weatherLogic.CurrentWeather;

import java.io.IOException;

public class Main {

    private static final String defaultApiKey = "21e80236d727d4dfc1b5cae33800a000";

    public static void main(String[] args) throws IOException {


        CurrentWeather currentWeather = new CurrentWeather(defaultApiKey);
        if (args.length == 1 && args[0].equals("--help")) {
            System.out.println("This is weather app");
            System.out.println("usage: [params_key] [city's date]");
            System.out.println("Options:" +
                    "\n-name {name}\t Input city's name" +
                    "\n-cityID {cityID}\t Input city's ID" +
                    "\n-zipcode  {zipcode} -countryCode {countrycode}\t Input city's zipcode and country code" +
                    "\n-lon {number} -lat {number} \t Input city's latitude and longtitide");
        } else if (args.length != 2 && args.length != 4) System.out.println("Try --help");


        if (args.length == 2) {
            try {


                if (args[0].equals("-name")) {
                    System.out.println(currentWeather.currentWeatherByCityName(args[1]));
                } else if (args[0].equals("-cityID")) {
                    System.out.println(currentWeather.currentWeatherByCityID(Integer.parseInt(args[1])));

                } else System.out.println("Wrong input. Try --help");
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. City ID must be a number. Try --help. ");
            }

        }


        if (args.length == 4) {
            try {


                if (args[0].equals("-zipcode") & args[2].equals("-countryCode")) {
                    System.out.println(currentWeather.currentWeatherByZIP(Integer.parseInt(args[1]), args[3]));
                } else if (args[0].equals("-lon") & args[2].equals("-lat")) {
                    System.out.println(currentWeather.currentWeatherByCoordinates(Integer.parseInt(args[1]), Integer.parseInt(args[3])));

                } else System.out.println("Wrong input. Try --help");
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Zipcode, longtitude and latitude must be numbers. Try --help");
            }
        }


    }


}

