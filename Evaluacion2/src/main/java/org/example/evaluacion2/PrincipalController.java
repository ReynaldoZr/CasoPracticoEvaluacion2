package org.example.evaluacion2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {
    

    @FXML
    private void abrirSolicitudServicio() {
        mostrarMensaje("Solicitud de Servicio");
    }

    @FXML
    private void consultarClientes() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("ConsultaClientes.fxml")
            );
            Stage ventana = new Stage();
            ventana.setTitle("Consulta de clientes");
            ventana.setScene(new Scene(loader.load()));
            ventana.show();
        } catch (IOException error) {
            mostrarMensaje("No se pudo abrir la consulta de clientes.");
        }
    }

    @FXML
    private void consultarServicios() {
        mostrarMensaje("Consulta de Servicios");
    }

    @FXML
    private void actualizarInformacion() {
        mostrarMensaje("Información actualizada.");
    }

    @FXML
    private void eliminarInformacion() {
        mostrarMensaje("Información eliminada.");
    }

    @FXML
    private void acercaDe() {
        mostrarMensaje("Sistema de Soporte Técnico");
    }

    @FXML
    private void salir() {
        Platform.exit();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sistema");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
