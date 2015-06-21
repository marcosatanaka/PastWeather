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
    private Label lblMaxTemp;

    @FXML
    private Label lblMinTemp;

    @FXML
    private Label lblMainInformation;

    @FXML
    private void initialize() {
        WeatherData weatherData = Test.getWeatherData();
        System.out.println(weatherData);
        if (weatherData != null) {
            lblPrecipitationProbability.setText(weatherData.getFormattedPrecipProbability());
            lblMainInformation.setText(weatherData.getSummary());
            lblMaxTemp.setText(weatherData.getTemperatureMax().toString());
            lblMinTemp.setText(weatherData.getTemperatureMin().toString());
        }
    }

    public void setPastWeatherApp(PastWeatherApp pastWeatherApp) {
        this.pastWeatherApp = pastWeatherApp;
    }

}