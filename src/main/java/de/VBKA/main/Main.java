package de.VBKA.main;

import de.VBKA.backend.controller.BookingParseController;
import de.VBKA.frontend.GuiController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        new GuiController().guiEntryPoint(primaryStage);
    }
}