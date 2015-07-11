package br.com.marcosatanaka.pastweather.view;

import br.com.marcosatanaka.pastweather.model.Constants;
import br.com.marcosatanaka.pastweather.model.WeatherData;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

/**
 * Test class for an API call.
 */
public class Test {

    public static WeatherData getWeatherData() {
        ForecastIO fio = new ForecastIO(Constants.FORECAST_IO_API_KEY);
        fio.setLang(Constants.LANG);
        fio.setUnits(Constants.UNITS);
        fio.setExcludeURL("hourly,minutely");
        //fio.setTime("2013-05-31T12:18:06");
        fio.getForecast("-23.398934", "-51.920031");

        FIODaily daily = new FIODaily(fio);
        if (daily.days() < 0) {
            System.out.println("No daily data.");
        } else {
            FIODataPoint day = daily.getDay(0);

            return WeatherData.builder()
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
                    .withApparentTemperature(day.apparentTemperature())
                    .withApparentTemperatureMin(day.apparentTemperatureMin())
                    .withApparentTemperatureMinTime(day.temperatureMinTime())
                    .withApparentTemperatureMax(day.temperatureMax())
                    .withApparentTemperatureMaxTime(day.temperatureMaxTime())
                    .withDewPoint(day.dewPoint())
                    .withWindSpeed(day.windSpeed())
                    .withWindBearing(day.windBearing())
                    .withCloudCover(day.cloudCover())
                    .withHumidity(day.humidity())
                    .withPressure(day.pressure())
                    .withVisibility(day.visibility())
                    .withOzone(day.ozone())
                    .build();
        }
        return null;
    }

    public static void getLatitudeAndLongitudeForLocation() throws Exception {
        WebService.setUserName(Constants.GEONAMES_APP_NAME);

        ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
        searchCriteria.setQ("maringá");

        ToponymSearchResult searchResult = WebService.search(searchCriteria);
        searchResult.getToponyms()
                .stream()
                .findFirst()
                .ifPresent(toponym -> System.out.println(toponym.getName() + " " + toponym.getCountryName() + " Latitude: " + toponym.getLatitude() + " Longitude: " + toponym.getLongitude()));
    }

}
