package com.example.evaluacion2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class PrincipalController {

    @FXML
    private void abrirRegistroCliente() {
        mostrarMensaje("Registro de Cliente");
    }

    @FXML
    private void abrirSolicitudServicio() {
        mostrarMensaje("Solicitud de Servicio");
    }

    @FXML
    private void consultarClientes() {
        mostrarMensaje("Consulta de Clientes");
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