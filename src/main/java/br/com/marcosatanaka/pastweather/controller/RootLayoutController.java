package br.com.marcosatanaka.pastweather.controller;

import br.com.marcosatanaka.pastweather.model.GeographicCoordinateFinder;
import br.com.marcosatanaka.pastweather.model.WeatherData;
import br.com.marcosatanaka.pastweather.model.WeatherDataFinder;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

import static br.com.marcosatanaka.pastweather.model.Translator.*;

/**
 * Controller to RootLayout.fxml.
 */
public class RootLayoutController {

    // Reference to the main application
    private PastWeatherApp pastWeatherApp;

    @FXML
    private Label lblPrecipitationProbability;

    @FXML
    private Label lblMaxTemp;

    @FXML
    private Label lblMinTemp;

    @FXML
    private Label lblMainInformation;

    @FXML
    private Label lblPrecipIntensity;

    @FXML
    private Label lblHumidity;

    @FXML
    private Label lblPressure;

    @FXML
    private Label lblOzone;

    @FXML
    private Label lblCloudCover;

    @FXML
    private Label lblDewPoint;

    @FXML
    private Label lblWindSpeed;

    @FXML
    private Label lblWindBearing;

    @FXML
    private TextField city;

    @FXML
    private DatePicker date;

    @FXML
    private void initialize() {
        date.setValue(LocalDate.now());
    }

    @FXML
    private void search() throws Exception {
        if (city.getText().length() > 0 && date.getValue() != null) {
            String latitude = GeographicCoordinateFinder.getLatitudeForLocation(city.getText());
            String longitude = GeographicCoordinateFinder.getLongitudeForLocation(city.getText());

            WeatherData weatherData = WeatherDataFinder.getWeatherData(latitude, longitude, date.getValue().toString());

            if (weatherData != null) {
                lblPrecipitationProbability.setText(translatePercentageValue(weatherData.getPrecipProbability()));
                lblMainInformation.setText(removeQuotationMarks(weatherData.getSummary()));
                lblMaxTemp.setText(translateTemperature(weatherData.getTemperatureMax()));
                lblMinTemp.setText(translateTemperature(weatherData.getTemperatureMin()));
                lblPrecipIntensity.setText(translatePrecipIntensity(weatherData.getPrecipIntensity()));
                lblHumidity.setText(translatePercentageValue(weatherData.getHumidity()));
                lblPressure.setText(translatePressure(weatherData.getPressure()));
                lblOzone.setText(translateOzone(weatherData.getOzone()));
                lblCloudCover.setText(translatePercentageValue(weatherData.getCloudCover()));
                lblDewPoint.setText(translateTemperature(weatherData.getDewPoint()));
                lblWindSpeed.setText(translateSpeed(weatherData.getWindSpeed()));
                lblWindBearing.setText(translateDirection(weatherData.getWindBearing()));
            }
        }
    }

    public void setPastWeatherApp(PastWeatherApp pastWeatherApp) {
        this.pastWeatherApp = pastWeatherApp;
    }

}