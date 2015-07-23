package br.com.marcosatanaka.pastweather.model;

import static br.com.marcosatanaka.pastweather.model.Constants.LINE_BREAK;

/**
 * Represents a data point gathered from the Forecast.io API.
 *
 * According to Forecast.io:
 *
 * A data point object represents the various weather phenomena occurring at a specific instant of time,
 * and has many varied properties. All of these properties (except time) are optional, and will only be
 * set if we [Forecast.io] have that type of information for that location and time.
 *
 * All units are dependant from the "units" option defined on API calls. Refer to the API site for more
 * information.
 *
 * Some javadoc have been copied from v2 Forecast API site, which can be accessed using this link:
 *
 * https://developer.forecast.io/docs/v2
 *
 * All Double values will return -1.0 if the information has not been returned by Forecast.io API.
 * Date-time values consider GMT time zone.
 *
 */
public class WeatherData {

    private String time;
    private String summary;
    private String icon;
    private String sunriseTime;
    private String sunsetTime;
    private Double moonPhase;
    private Double nearestStormDistance;
    private Double nearestStormBearing;
    private Double precipIntensity;
    private Double precipIntensityMax;
    private String precipIntensityMaxTime;
    private Double precipProbability;
    private String precipType;
    private Double precipAccumulation;
    private Double temperature;
    private Double temperatureMin;
    private String temperatureMinTime;
    private Double temperatureMax;
    private String temperatureMaxTime;
    private Double apparentTemperature;
    private Double apparentTemperatureMin;
    private String apparentTemperatureMinTime;
    private Double apparentTemperatureMax;
    private String aparentTemperatureMaxTime;
    private Double dewPoint;
    private Double windSpeed;
    private Double windBearing;
    private Double cloudCover;
    private Double humidity;
    private Double pressure;
    private Double visibility;
    private Double ozone;

    /**
     * @return Time at which this data point occurs.
     */
    public String getTime() {
        return time;
    }

    /**
     * @return A human-readable text summary of this data point.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @return A machine-readable text summary of this data point, suitable for selecting an icon for display.
     * See https://developer.forecast.io/docs/v2 for details.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @return Time of the last sunrise before the solar noon closest to local noon on the given day.
     */
    public String getSunriseTime() {
        return sunriseTime;
    }

    /**
     * @return Time of the first sunset after the solar noon closest to local noon on the given day.
     */
    public String getSunsetTime() {
        return sunsetTime;
    }

    /**
     * @return A number representing the fractional part of the lunation number of the given day.
     * This can be thought of as the “percentage complete” of the current lunar month: a value of
     * 0 represents a new moon, a value of 0.25 represents a first quarter moon, a value of 0.5
     * represents a full moon, and a value of 0.75 represents a last quarter moon. (The ranges
     * in between these represent waxing crescent, waxing gibbous, waning gibbous, and waning
     * crescent moons, respectively.)
     */
    public Double getMoonPhase() {
        return moonPhase;
    }

    /**
     * @return A numerical value representing the distance to the nearest storm in miles.
     */
    public Double getNearestStormDistance() {
        return nearestStormDistance;
    }

    /**
     * @return A numerical value representing the direction of the nearest storm in degrees,
     * with true north at 0° and progressing clockwise.
     */
    public Double getNearestStormBearing() {
        return nearestStormBearing;
    }

    /**
     * @return A numerical value representing the average expected intensity of precipitation occurring
     * at the given time conditional on probability (that is, assuming any precipitation occurs at all).
     * A very rough guide is that a value of 0 in./hr. corresponds to no precipitation, 0.002 in./hr.
     * corresponds to very light precipitation, 0.017 in./hr. corresponds to light precipitation, 0.1 in./hr.
     * corresponds to moderate precipitation, and 0.4 in./hr. corresponds to heavy precipitation.
     */
    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    /**
     * @return A numerical value representing the maximumum expected intensity of precipitation
     * on the given day in inches of liquid water per hour.
     */
    public Double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    /**
     * @return Time at which precipIntensityMax occurs.
     */
    public String getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    /**
     * @return A numerical value between 0 and 1 (inclusive) representing the probability of precipitation
     * occuring at the given time.
     */
    public Double getPrecipProbability() {
        return precipProbability;
    }

    public String getFormattedPrecipProbability() {
        return String.valueOf(getPrecipProbability() * 100) + " %";
    }

    /**
     * @return A string representing the type of precipitation occurring at the given time.
     * See https://developer.forecast.io/docs/v2 for details.
     */
    public String getPrecipType() {
        return precipType;
    }

    /**
     * @return The amount of snowfall accumulation expected to occur on the given day.
     * (If no accumulation is expected, this property will not be defined.)

     */
    public Double getPrecipAccumulation() {
        return precipAccumulation;
    }

    /**
     * @return A numerical value representing the temperature at the given time.
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * @return Numerical value representing the minimum temperature on the given day.
     */
    public Double getTemperatureMin() {
        return temperatureMin;
    }

    /**
     * @return Time at which temperatureMin occurs.
     */
    public String getTemperatureMinTime() {
        return temperatureMinTime;
    }

    /**
     * @return Numerical value representing the maximum temperature on the given day.
     */
    public Double getTemperatureMax() {
        return temperatureMax;
    }

    /**
     * @return Time at which temperatureMax occurs.
     */
    public String getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    /**
     * @return A numerical value representing the apparent (or “feels like”) temperature at the given time.
     */
    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    /**
     * @return A numerical value representing the minimum apparent temperature on the given day.
     */
    public Double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    /**
     * @return Time at which apparentTemperatureMin occurs.
     */
    public String getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    /**
     * @return A numerical value representing the maximum apparent temperature on the given day.
     */
    public Double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    /**
     * @return Time at which apparentTemperatureMax occurs.
     */
    public String getAparentTemperatureMaxTime() {
        return aparentTemperatureMaxTime;
    }

    /**
     * @return A numerical value representing the dew point at the given time.
     */
    public Double getDewPoint() {
        return dewPoint;
    }

    /**
     * @return A numerical value representing the wind speed.
     */
    public Double getWindSpeed() {
        return windSpeed;
    }

    /**
     * @return A numerical value representing the direction that the wind is coming from in degrees,
     * with true north at 0° and progressing clockwise.
     */
    public Double getWindBearing() {
        return windBearing;
    }

    /**
     * @return A numerical value between 0 and 1 (inclusive) representing the percentage of sky occluded by clouds.
     * A value of 0 corresponds to clear sky, 0.4 to scattered clouds, 0.75 to broken cloud cover, and 1 to completely
     * overcast skies.
     */
    public Double getCloudCover() {
        return cloudCover;
    }

    public String getFormattedCloudCover() {
        return String.valueOf(getCloudCover() * 100) + " %";
    }

    /**
     * @return A numerical value between 0 and 1 (inclusive) representing the relative humidity.
     */
    public Double getHumidity() {
        return humidity;
    }

    public String getFormattedHumidity() {
        return String.valueOf(getHumidity() * 100) + " %";
    }

    /**
     * @return A numerical value representing the sea-level air pressure in millibars.
     */
    public Double getPressure() {
        return pressure;
    }

    /**
     * @return A numerical value representing the average visibility in miles, capped at 10 miles.
     */
    public Double getVisibility() {
        return visibility;
    }

    /**
     * @return A numerical value representing the columnar density of total atmospheric ozone at the
     * given time in Dobson units.
     */
    public Double getOzone() {
        return ozone;
    }

    @Override
    public String toString() {
        return "WeatherData:" + LINE_BREAK +
                "time = " + time + LINE_BREAK +
                "summary = " + summary + LINE_BREAK +
                "icon = " + icon + LINE_BREAK +
                "sunriseTime = " + sunriseTime + LINE_BREAK +
                "sunsetTime = " + sunsetTime + LINE_BREAK +
                "moonPhase = " + moonPhase + LINE_BREAK +
                "nearestStormDistance = " + nearestStormDistance + LINE_BREAK +
                "nearestStormBearing = " + nearestStormBearing + LINE_BREAK +
                "precipIntensity = " + precipIntensity + LINE_BREAK +
                "precipIntensityMax = " + precipIntensityMax + LINE_BREAK +
                "precipIntensityMaxTime = " + precipIntensityMaxTime + '\'' + LINE_BREAK +
                "precipProbability = " + precipProbability + LINE_BREAK +
                "precipType = " + precipType + LINE_BREAK +
                "precipAccumulation = " + precipAccumulation + LINE_BREAK +
                "temperature = " + temperature + LINE_BREAK +
                "temperatureMin = " + temperatureMin + LINE_BREAK +
                "temperatureMinTime = '" + temperatureMinTime + LINE_BREAK +
                "temperatureMax = " + temperatureMax + LINE_BREAK +
                "temperatureMaxTime = '" + temperatureMaxTime + LINE_BREAK +
                "apparentTemperature = " + apparentTemperature + LINE_BREAK +
                "apparentTemperatureMin = " + apparentTemperatureMin + LINE_BREAK +
                "apparentTemperatureMinTime = " + apparentTemperatureMinTime + LINE_BREAK +
                "apparentTemperatureMax = " + apparentTemperatureMax + LINE_BREAK +
                "apparentTemperatureMaxTime = " + aparentTemperatureMaxTime + LINE_BREAK +
                "dewPoint = " + dewPoint + LINE_BREAK +
                "windSpeed = " + windSpeed + LINE_BREAK +
                "windBearing = " + windBearing + LINE_BREAK +
                "cloudCover = " + cloudCover + LINE_BREAK +
                "humidity = " + humidity + LINE_BREAK +
                "pressure = " + pressure + LINE_BREAK +
                "visibility = " + visibility + LINE_BREAK +
                "ozone = " + ozone +
                '}';
    }

    private WeatherData(Builder builder) {
        time = builder.time;
        summary = builder.summary;
        icon = builder.icon;
        sunriseTime = builder.sunriseTime;
        sunsetTime = builder.sunsetTime;
        moonPhase = builder.moonPhase;
        nearestStormDistance = builder.nearestStormDistance;
        nearestStormBearing = builder.nearestStormBearing;
        precipIntensity = builder.precipIntensity;
        precipIntensityMax = builder.precipIntensityMax;
        precipIntensityMaxTime = builder.precipIntensityMaxTime;
        precipProbability = builder.percipProbability;
        precipType = builder.precipType;
        precipAccumulation = builder.precipAccumulation;
        temperature = builder.temperature;
        temperatureMin = builder.temperatureMin;
        temperatureMinTime = builder.temperatureMinTime;
        temperatureMax = builder.temperatureMax;
        temperatureMaxTime = builder.temperatureMaxTime;
        apparentTemperature = builder.apparentTemperature;
        apparentTemperatureMin = builder.apparentTemperatureMin;
        apparentTemperatureMinTime = builder.apparentTemperatureMinTime;
        apparentTemperatureMax = builder.apparentTemperatureMax;
        aparentTemperatureMaxTime = builder.apparentTemperatureMaxTime;
        dewPoint = builder.dewPoint;
        windSpeed = builder.windSpeed;
        windBearing = builder.windBearing;
        cloudCover = builder.cloudCover;
        humidity = builder.humidity;
        pressure = builder.pressure;
        visibility = builder.visibility;
        ozone = builder.ozone;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String time;
        private String summary;
        private String icon;
        private String sunriseTime;
        private String sunsetTime;
        private Double moonPhase;
        private Double nearestStormDistance;
        private Double nearestStormBearing;
        private Double precipIntensity;
        private Double precipIntensityMax;
        private String precipIntensityMaxTime;
        private Double percipProbability;
        private String precipType;
        private Double precipAccumulation;
        private Double temperature;
        private Double temperatureMin;
        private String temperatureMinTime;
        private Double temperatureMax;
        private String temperatureMaxTime;
        private Double apparentTemperature;
        private Double apparentTemperatureMin;
        private String apparentTemperatureMinTime;
        private Double apparentTemperatureMax;
        private String apparentTemperatureMaxTime;
        private Double dewPoint;
        private Double windSpeed;
        private Double windBearing;
        private Double cloudCover;
        private Double humidity;
        private Double pressure;
        private Double visibility;
        private Double ozone;

        private Builder() {
        }

        public Builder withTime(String time) {
            this.time = time;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public Builder withSunriseTime(String sunriseTime) {
            this.sunriseTime = sunriseTime;
            return this;
        }

        public Builder withSunsetTime(String sunsetTime) {
            this.sunsetTime = sunsetTime;
            return this;
        }

        public Builder withMoonPhase(Double moonPhase) {
            this.moonPhase = moonPhase;
            return this;
        }

        public Builder withNearestStormDistance(Double nearestStormDistance) {
            this.nearestStormDistance = nearestStormDistance;
            return this;
        }

        public Builder withNearestStormBearing(Double nearestStormBearing) {
            this.nearestStormBearing = nearestStormBearing;
            return this;
        }

        public Builder withPrecipIntensity(Double precipIntensity) {
            this.precipIntensity = precipIntensity;
            return this;
        }

        public Builder withPrecipIntensityMax(Double precipIntensityMax) {
            this.precipIntensityMax = precipIntensityMax;
            return this;
        }

        public Builder withPrecipIntensityMaxTime(String precipIntensityMaxTime) {
            this.precipIntensityMaxTime = precipIntensityMaxTime;
            return this;
        }

        public Builder withPercipProbability(Double percipProbability) {
            this.percipProbability = percipProbability;
            return this;
        }

        public Builder withPrecipType(String precipType) {
            this.precipType = precipType;
            return this;
        }

        public Builder withPrecipAccumulation(Double precipAccumulation) {
            this.precipAccumulation = precipAccumulation;
            return this;
        }

        public Builder withTemperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder withTemperatureMin(Double temperatureMin) {
            this.temperatureMin = temperatureMin;
            return this;
        }

        public Builder withTemperatureMinTime(String temperatureMinTime) {
            this.temperatureMinTime = temperatureMinTime;
            return this;
        }

        public Builder withTemperatureMax(Double temperatureMax) {
            this.temperatureMax = temperatureMax;
            return this;
        }

        public Builder withTemperatureMaxTime(String temperatureMaxTime) {
            this.temperatureMaxTime = temperatureMaxTime;
            return this;
        }

        public Builder withApparentTemperature(Double apparentTemperature) {
            this.apparentTemperature = apparentTemperature;
            return this;
        }

        public Builder withApparentTemperatureMin(Double apparentTemperatureMin) {
            this.apparentTemperatureMin = apparentTemperatureMin;
            return this;
        }

        public Builder withApparentTemperatureMinTime(String apparentTemperatureMinTime) {
            this.apparentTemperatureMinTime = apparentTemperatureMinTime;
            return this;
        }

        public Builder withApparentTemperatureMax(Double apparentTemperatureMax) {
            this.apparentTemperatureMax = apparentTemperatureMax;
            return this;
        }

        public Builder withApparentTemperatureMaxTime(String apparentTemperatureMaxTime) {
            this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
            return this;
        }

        public Builder withDewPoint(Double dewPoint) {
            this.dewPoint = dewPoint;
            return this;
        }

        public Builder withWindSpeed(Double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Builder withWindBearing(Double windBearing) {
            this.windBearing = windBearing;
            return this;
        }

        public Builder withCloudCover(Double cloudCover) {
            this.cloudCover = cloudCover;
            return this;
        }

        public Builder withHumidity(Double humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder withPressure(Double pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder withVisibility(Double visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder withOzone(Double ozone) {
            this.ozone = ozone;
            return this;
        }

        public WeatherData build() {
            return new WeatherData(this);
        }
    }
}