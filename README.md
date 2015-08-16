# PastWeather
A JavaFX application that provides weather information about a location in the present, past or future. It uses the Forecast.io API through the library provided by [ForecastIO-Lib-Java](https://github.com/dvdme/forecastio-lib-java).
 
## Getting started
This project it's being developed on IntelliJ IDEA, with Java 8 and JavaFX.
For being able to use it, you will have to register at Forecast.io and GeoNames for a developer key:
- **Forecast.io:** go to https://developer.forecast.io to register. The first 1,000 calls per day are free. After registering, you will recive an API key that has to be placed at `FORECAST_IO_API_KEY` constant at `Constants` class.
- **GeoNames:** go to http://www.geonames.org/login to register. After that you will be able to register an application name for your app. That name has to be placed at `GEONAMES_APP_NAME` constant at `Constants` class. 
 
## Done:
- Consume data from Forecast.io API.
- Create user interface using JavaFX.
- Implement the user interface logic.
- Enhance the user interface adding more weather information.
 
## To Do:
- Display unit symbols according to language.
- Add icon on the app. :cloud:
- Gif animation according to precipitation intensity. :smiley:
- Autocomplete for city field.
 
## External Libraries:
PastWeather uses [ForecastIO-Lib-Java](https://github.com/dvdme/forecastio-lib-java) to communicate with the Forecast.io API. This is a dependency on pom.xml.

It also uses [GeoNames API](http://www.geonames.org/about.html) to get latitude and longitude of a user-entered location. This dependency is in the `/jar` directory.

`/jar` directory also has the [JDOM](http://www.jdom.org) library as a dependency of GeoNames API.
