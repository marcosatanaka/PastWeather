package br.com.marcosatanaka.pastweather.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Files;

/**
 * Application main class which has the start() method, the main entry point for all JavaFX applications.
 */
public class PastWeatherApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PastWeather");

        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getURL("RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);

        // Give the controller access to the main app.
        RootLayoutController controller = loader.getController();
        controller.setPastWeatherApp(this);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    protected URL getURL(String fileName) {
        URL url;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        url = cl.getResource(fileName);
        if (url == null) {
            cl = Files.class.getClassLoader();
            url = cl.getResource(fileName);
        }
        return url;
    }

}