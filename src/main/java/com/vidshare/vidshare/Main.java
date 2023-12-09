package com.vidshare.vidshare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signin-view.fxml"));
            Parent root = loader.load();
            SignInController ssc = loader.getController();
            Firebase fbase = new Firebase();
            ssc.setInstance(fbase, primaryStage);
            Scene scene = new Scene(root);
            primaryStage.setTitle("Vidshare");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}