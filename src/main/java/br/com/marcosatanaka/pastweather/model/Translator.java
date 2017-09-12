package br.com.marcosatanaka.pastweather.model;

/**
 * Transforms the weather data into a more readable form.
 */
public class Translator {

    private Translator() {
    }

    public static String translatePercentageValue(Double value) {
        return String.format("%s%%", value * 100);
    }

    public static String translateTemperature(Double value) {
        return String.format("%s %sC", value, (char)186);
    }

    public static String translatePressure(Double value) {
        return String.format("%s mbar", value);
    }

    public static String translateOzone(Double value) {
        return String.format("%s DU", value);
    }

    public static String translatePrecipIntensity(Double value) {
        return String.format("%s in/hr", value);
    }

    public static String translateSpeed(Double value) {
        return String.format("%s km/h", value);
    }

    public static String translateDirection(Double value) {
        return String.format("%s %s", value, (char)186);
    }

    public static String removeQuotationMarks(String string) {
        return string.replace("\"", "");
    }

}
