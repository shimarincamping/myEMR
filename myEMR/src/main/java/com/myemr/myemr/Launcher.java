package com.myemr.myemr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class Launcher extends Application {

    public final static double SCREEN_WIDTH = 1536.0;
    public final static double SCREEN_HEIGHT = 864.0;

    public void start(Stage stage) throws Exception {

        // Launches the home screen
        HomeScreen homeScreen = new HomeScreen();
        Scene scene = homeScreen.getHomeScene();
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);

        stage.setMaximized(true);
        stage.setTitle("myEMR | Home");
        stage.getIcons().add(new Image(new FileInputStream("src/main/resources/images/app_icon.png")));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
