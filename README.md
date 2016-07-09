# weather (русский)

Данный проект взаимодействует с API открытого сервиса http://openweathermap.org/

Он может быть использован и как библиотека, и как исполнимый файл. 
Возможности:
 - текущая погода по названию города
 - текущая погода по ID города (http://bulk.openweathermap.org/sample/ - здесь есть список возможных ID)
 - текущая погода по почтовому индексу и коду страны
 - текущая погода по географическим координатам.

В случае использования как исполнимого файла: запустить в консоли команду 	

	java -jar weather-0.1-SNAPSHOT-jar-with-dependencies.jar --help. 
    
Далее прочитать справку и пользоваться по назначению. 

В случае использования как библиотеки, следует подключить **weather-0.1-SNAPSHOT-jar-with-dependencies.jar** как библиотеку в настройках проекта.
Взаимодействие с ней происходит через класс-обертку CurrentWeather. В этом случае в конструктор класса необходимо подать API-ключ, который можно получить на сайте сервиса, либо воспользоваться моим: 21e80236d727d4dfc1b5cae33800a000

Класс имеет все необходимые возможности, у каждого метода имеется javadoc. Методы возвращают класс WeatherParams, поля которого содержат погодные данные. У него переопределен метод toString для большего удобства.

Помимо этого в классе существуют методы setResponseMode и setKey. Первый метод позволяет изменить тип возвращаемых данных после взаимодействия с API сервиса погоды (не реализован, стоят заглушки), а второй позволяет сменить API-ключ.

Дополнительные нюансы: запрос по имени города не является строгим. Если ввести любую строку как имя города, то практически всегда сервис подберет схожий по написанию город. Исключение составляют строки с цифрами и другими небуквенными знаками.

# weather (english)
This project communicates with API of the open service  http://openweathermap.org/

It can be used like library or like executable application.
Usecases:
- current weather by city's name
- current weather by city's ID (http://bulk.openweathermap.org/sample/ -- full ID's list)
- current weather by ZIP-code and country code (like uk, ru etc)
- current weather by geografical coordinates

In case of using this like executable file: type command in console 

	java -jar weather-0.1-SNAPSHOT-jar-with-dependencies.jar --help
    
Then read manual and use it.

In case of using it like library, you have to add weather-0.1-SNAPSHOT-jar-with-dependencies.jar --help in project dependencyes.
Using of this library represents a wrapper class CurrentWeather. In this case in the class constructor you have to transfer your API-key, which one you can get on weather service website, or use mine: 21e80236d727d4dfc1b5cae33800a000

Wrapper class have all capabilityes you need and all methods have javadoc. Methods return WeatherParams class, which fields contains weather's parametrs. It have overrided method toString for better using.
Also there are methods like setResponseMode and setKey. First one allows you change type of returning data after API request (dont implimented yet), second one allows you to change API-key.

Some additional nuance: request by name dont have to be exact. If you will input any string as city's name, you will alsmost always get some answer. An exception is strings with non-letter symbols.
