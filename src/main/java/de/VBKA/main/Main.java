package de.VBKA.main;

import de.VBKA.database.DataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {

        DataBase.init();
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Dashboard.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.setTitle("Volksbank Kontoauszug Analyse");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();

    }
}