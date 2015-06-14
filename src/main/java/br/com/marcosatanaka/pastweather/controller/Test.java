package br.com.marcosatanaka.pastweather.controller;

import br.com.marcosatanaka.pastweather.entity.Constants;
import br.com.marcosatanaka.pastweather.entity.WeatherData;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;

/**
 * Test class for a API call.
 */
public class Test {

    public static void main(String[] args) {
        ForecastIO fio = new ForecastIO(Constants.API_KEY);
        fio.setLang(Constants.LANG);
        fio.setUnits(Constants.UNITS);
        fio.setExcludeURL("hourly,minutely");
        //fio.setTime("2013-05-31T12:18:06");
        fio.getForecast("40.738180", "-73.989981");

        FIODaily daily = new FIODaily(fio);
        if (daily.days() < 0) {
            System.out.println("No daily data.");
        } else {
            FIODataPoint day = daily.getDay(0);

            WeatherData weatherData = WeatherData.builder()
                    .withTime(day.time())
                    .withSummary(day.summary())
                    .withIcon(day.icon())
                    .withSunriseTime(day.sunriseTime())
                    .withSunsetTime(day.sunsetTime())
                    .withMoonPhase(null)
                    .withNearestStormDistance(day.nearestStormDistance())
                    .withNearestStormBearing(day.nearestStormBearing())
                    .withPrecipIntensity(day.precipIntensity())
                    .withPrecipIntensityMax(day.precipIntensityMax())
                    .withPrecipIntensityMaxTime(day.precipIntensityMaxTime())
                    .withPercipProbability(day.precipProbability())
                    .withPrecipType(day.precipType())
                    .withPrecipAccumulation(day.precipAccumulation())
                    .withTemperature(day.temperature())
                    .withTemperatureMin(day.temperatureMin())
                    .withTemperatureMinTime(day.temperatureMinTime())
                    .withTemperatureMax(day.temperatureMax())
                    .withTemperatureMaxTime(day.temperatureMaxTime())
                    .withAparentTemperature(day.apparentTemperature())
                    .withAparentTemperatureMin(day.apparentTemperatureMin())
                    .withAparentTemperatureMinTime(day.temperatureMinTime())
                    .withAparentTemperatureMax(day.temperatureMax())
                    .withAparentTemperatureMaxTime(day.temperatureMaxTime())
                    .withDewPoint(day.dewPoint())
                    .withWindSpeed(day.windSpeed())
                    .withWindBearing(day.windBearing())
                    .withCloudCover(day.cloudCover())
                    .withHumidity(day.humidity())
                    .withPressure(day.pressure())
                    .withVisibility(day.visibility())
                    .withOzone(day.ozone())
                    .build();

            System.out.println(weatherData);
        }
    }

}
