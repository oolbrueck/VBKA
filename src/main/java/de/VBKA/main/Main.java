package de.VBKA.main;

import de.VBKA.backend.controller.BookingParseController;
import de.VBKA.frontend.GuiController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {

        List<String> bookings;
        BookingParseController bookingParseController = new BookingParseController();
        try {
            bookings = bookingParseController.parseBookings();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bookings.stream().forEach(s -> bookingParseController.parseAmount(s));

        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/entryGUI.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.setTitle("Volksbank Kontoauszug Analyse");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();

    }
}