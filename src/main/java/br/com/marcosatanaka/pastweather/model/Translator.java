package br.com.marcosatanaka.pastweather.model;

/**
 * Transforms the weather data into a more readable form.
 */
public class Translator {

    private static final String CELSIUS = " " + (char)186 + "C";

    public static String translatePercentageValue(Double value) {
        return String.valueOf(value * 100) + " %";
    }

    public static String translateTemperature(Double value) {
        return String.valueOf(value) + CELSIUS;
    }

}
