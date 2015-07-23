package br.com.marcosatanaka.pastweather.view;

import br.com.marcosatanaka.pastweather.application.GeographicCoordinateFinder;
import br.com.marcosatanaka.pastweather.application.PastWeatherApp;
import br.com.marcosatanaka.pastweather.application.WeatherDataFinder;
import br.com.marcosatanaka.pastweather.model.WeatherData;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

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
                lblPrecipitationProbability.setText(weatherData.getFormattedPrecipProbability());
                lblMainInformation.setText(weatherData.getSummary());
                lblMaxTemp.setText(weatherData.getTemperatureMax().toString());
                lblMinTemp.setText(weatherData.getTemperatureMin().toString());
                lblPrecipIntensity.setText(weatherData.getPrecipIntensity().toString());
                lblHumidity.setText(weatherData.getFormattedHumidity());
                lblPressure.setText(weatherData.getPressure().toString());
                lblOzone.setText(weatherData.getOzone().toString());
                lblCloudCover.setText(weatherData.getFormattedCloudCover());
                lblDewPoint.setText(weatherData.getDewPoint().toString());
                lblWindSpeed.setText(weatherData.getWindSpeed().toString());
                lblWindBearing.setText(weatherData.getWindBearing().toString());
            }
        }
    }

    public void setPastWeatherApp(PastWeatherApp pastWeatherApp) {
        this.pastWeatherApp = pastWeatherApp;
    }

}