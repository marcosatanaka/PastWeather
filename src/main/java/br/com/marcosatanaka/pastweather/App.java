package br.com.marcosatanaka.pastweather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Files;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootLayout = new FXMLLoader(getURL("RootLayout.fxml")).load();

        primaryStage.setTitle("PastWeather");
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }

    private URL getURL(String fileName) {
        URL url;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        url = classLoader.getResource(fileName);
        if (url == null) {
            classLoader = Files.class.getClassLoader();
            url = classLoader.getResource(fileName);
        }
        return url;
    }

}