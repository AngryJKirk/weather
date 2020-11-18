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

It can be used like a library or like an executable application.
Usecases:
- current weather by city's name
- current weather by city's ID (http://bulk.openweathermap.org/sample/ -- full IDs list)
- current weather by ZIP-code and country code (like uk, ru etc)
- current weather by geographical coordinates

In case of using it as an executable file just type command in console 

	java -jar weather-0.1-SNAPSHOT-jar-with-dependencies.jar --help
    
Then read the manual and use it.

In case of using it as library, you have to add **weather-0.1-SNAPSHOT-jar-with-dependencies.jar** to the project dependencies.
Using of this library represents a wrapper class CurrentWeather. In this case in the class constructor you have to transfer your API-key, which you can get on the weather service website, or use mine: 21e80236d727d4dfc1b5cae33800a000

Wrapper class has all capabilities you need and all the methods of the class have javadoc. Methods return an object of WeatherParams class, which fields contain weather's parameters. It has an overrided method toString for better experience.
Also there are methods like setResponseMode and setKey. The first one allows you to change the type of returned data after an API request (not implimented yet), the second one allows you to change the API-key.

One more thing: a request by name doesn't have to be exact. If you input any string as city's name,  alsmost always you will get some answer. An exception is strings with non-letter symbols.
