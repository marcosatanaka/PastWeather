package br.com.marcosatanaka.pastweather.view;

import br.com.marcosatanaka.pastweather.PastWeatherApp;
import br.com.marcosatanaka.pastweather.model.WeatherData;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
            String latitude = Test.getLatitudeForLocation(city.getText());
            String longitude = Test.getLongitudeForLocation(city.getText());

            WeatherData weatherData = Test.getWeatherData(latitude, longitude, date.getValue().toString());

            if (weatherData != null) {
                lblPrecipitationProbability.setText(weatherData.getFormattedPrecipProbability());
                lblMainInformation.setText(weatherData.getSummary());
                lblMaxTemp.setText(weatherData.getTemperatureMax().toString());
                lblMinTemp.setText(weatherData.getTemperatureMin().toString());
            }
        }
    }

    public void setPastWeatherApp(PastWeatherApp pastWeatherApp) {
        this.pastWeatherApp = pastWeatherApp;
    }

}