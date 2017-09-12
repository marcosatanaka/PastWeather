package br.com.marcosatanaka.pastweather.controller;

import br.com.marcosatanaka.pastweather.model.WeatherData;
import br.com.marcosatanaka.pastweather.service.GeographicCoordinateFinder;
import br.com.marcosatanaka.pastweather.service.WeatherDataFinder;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

import static br.com.marcosatanaka.pastweather.model.Translator.*;
import static java.util.Objects.isNull;
import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.Alert.AlertType.INFORMATION;

/**
 * Controller to RootLayout.fxml.
 */
public class RootLayoutController {

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
    private void search() {
        if (!validForm()) {
            return;
        }

        try {
            String latitude = GeographicCoordinateFinder.getLatitude(city.getText());
            String longitude = GeographicCoordinateFinder.getLongitude(city.getText());
            WeatherData weatherData = WeatherDataFinder.toWeatherData(latitude, longitude, date.getValue().toString());
            updateForm(weatherData);
        } catch (Exception e) {
            showAlert(ERROR, e.getMessage());
        }
    }

    private boolean validForm() {
        if (city.getText().isEmpty()) {
            showAlert(INFORMATION, "You have to select a city!");
            return false;
        }
        if (isNull(date.getValue())) {
            showAlert(INFORMATION, "You have to select a date!");
            return false;
        }

        return true;
    }

    private void updateForm(WeatherData weatherData) {
        if (isNull(weatherData)) {
            showAlert(INFORMATION, "No forecast data found for this day!");
            return;
        }

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

    private void showAlert(Alert.AlertType alertType, String contentText) {
        new Alert(alertType, contentText)
                .show();
    }

}