package br.com.marcosatanaka.pastweather.view;

import br.com.marcosatanaka.pastweather.PastWeatherApp;
import br.com.marcosatanaka.pastweather.model.WeatherData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller to RootLayout.fxml.
 */
public class RootLayoutController {

    // Reference to the main application
    private PastWeatherApp pastWeatherApp;

    @FXML
    private Label lblPrecipitationProbability;

    @FXML
    private Label lblMainInformation;

    @FXML
    private Label lblSecondaryInformation;

    @FXML
    private void initialize() {
        WeatherData weatherData = Test.getWeatherData();
        if (weatherData != null) {
            lblPrecipitationProbability.setText(weatherData.getFormattedPrecipProbability());
            lblMainInformation.setText(weatherData.getSummary());
            lblSecondaryInformation.setText("Apparent maximum temperature: " + weatherData.getApparentTemperatureMax().toString());
        }
    }

    public void setPastWeatherApp(PastWeatherApp pastWeatherApp) {
        this.pastWeatherApp = pastWeatherApp;
    }

}