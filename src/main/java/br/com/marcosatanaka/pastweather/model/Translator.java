package br.com.marcosatanaka.pastweather.model;

/**
 * Transforms the weather data into a more readable form.
 */
public class Translator {

    public static String translatePercentageValue(Double value) {
        return String.valueOf(value * 100) + " %";
    }

    public static String translateTemperature(Double value) {
        return String.valueOf(value) + " " + (char)186 + "C";
    }

    public static String translatePressure(Double value) {
        return String.valueOf(value) + " mbar";
    }

    public static String translateOzone(Double value) {
        return String.valueOf(value) + " DU";
    }

    public static String translatePrecipIntensity(Double value) {
        return String.valueOf(value) + " in/hr";
    }

    public static String translateSpeed(Double value) {
        return String.valueOf(value) + " km/h";
    }

    public static String translateDirection(Double value) {
        return String.valueOf(value) + " " + (char)186;
    }

    public static String removeQuotationMarks(String string) {
        return string.replace("\"", "");
    }

}
