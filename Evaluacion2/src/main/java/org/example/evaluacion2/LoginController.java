package org.example.evaluacion2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private void iniciarSesion() {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Campos incompletos",
                    "Datos requeridos",
                    "Por favor, complete todos los campos para continuar."
            );
            return;
        }

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Inicio de sesión exitoso",
                "Bienvenido al sistema",
                "Credenciales correctas. Ha ingresado como: " + usuario
        );
    }

    @FXML
    private void salir() {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar salida");
        confirmacion.setHeaderText("¿Está seguro de que desea salir?");
        confirmacion.setContentText("Se cerrará la aplicación.");

        Optional<ButtonType> respuesta = confirmacion.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            Stage stage = (Stage) btnSalir.getScene().getWindow();
            stage.close();
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}