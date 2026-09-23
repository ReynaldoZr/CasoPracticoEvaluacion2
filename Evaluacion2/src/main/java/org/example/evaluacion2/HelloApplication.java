package org.example.evaluacion2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        try {
            URL fxmlLocation = HelloApplication.class.getResource("Inicio-Sesion.fxml");

            if (fxmlLocation == null) {
                throw new IllegalStateException("No se encontró el archivo FXML: Inicio-Sesion.fxml");
            }

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Sistema de Gestión - Iniciar Sesión");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
            mostrarErrorFatal("Error al iniciar la aplicación", e.getMessage());
        }
    }

    private void mostrarErrorFatal(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Crítico");
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
