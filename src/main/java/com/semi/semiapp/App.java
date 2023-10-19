package com.semi.semiapp;

import com.semi.view.Pay;
import com.semi.view.LoginGUI;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
/*
        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();*/
        LoginGUI f = new LoginGUI();
        f.show();

    }

    public static void main(String[] args) {
        launch();
    }

}