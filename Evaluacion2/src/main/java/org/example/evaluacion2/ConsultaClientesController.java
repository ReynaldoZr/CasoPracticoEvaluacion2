package org.example.evaluacion2;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ConsultaClientesController {

    @FXML
    private TableView<RegistroCliente> tablaClientes;

    @FXML
    private TableColumn<RegistroCliente, String> columnaNombre;

    @FXML
    private TableColumn<RegistroCliente, String> columnaTipo;

    @FXML
    private TableColumn<RegistroCliente, String> columnaCiudad;

    @FXML
    private TableColumn<RegistroCliente, LocalDate> columnaFecha;

    @FXML
    private TableColumn<RegistroCliente, String> columnaSolicitud;

    private final ObservableList<RegistroCliente> clientes =
            FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        columnaNombre.setCellValueFactory(datos ->
                new ReadOnlyStringWrapper(datos.getValue().getNombreCompleto()));

        columnaTipo.setCellValueFactory(datos ->
                new ReadOnlyStringWrapper(datos.getValue().getTipoCliente()));

        columnaCiudad.setCellValueFactory(datos ->
                new ReadOnlyStringWrapper(datos.getValue().getCiudad()));

        columnaFecha.setCellValueFactory(datos ->
                new ReadOnlyObjectWrapper<>(datos.getValue().getFechaNacimiento()));

        columnaSolicitud.setCellValueFactory(datos ->
                new ReadOnlyStringWrapper(datos.getValue().getTipoSolicitud()));

        clientes.add(new RegistroCliente(
                "Ana", "López", "Frecuente", "Managua",
                LocalDate.of(2002, 5, 10), "Soporte técnico"
        ));

        clientes.add(new RegistroCliente(
                "Carlos", "Ruiz", "Nuevo", "Masaya",
                LocalDate.of(1998, 11, 23), "Instalación"
        ));

        tablaClientes.setItems(clientes);
    }

    @FXML
    private void mostrarInformacion() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText("Clientes registrados");
        alerta.setContentText("Cantidad de clientes: " + clientes.size());
        alerta.showAndWait();
    }

    @FXML
    private void verClienteSeleccionado() {
        RegistroCliente cliente =
                tablaClientes.getSelectionModel().getSelectedItem();

        if (cliente == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText("No seleccionaste un cliente");
            alerta.setContentText("Selecciona una fila antes de continuar.");
            alerta.showAndWait();
            return;
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Detalle del cliente");
        alerta.setHeaderText(cliente.getNombreCompleto());
        alerta.setContentText(
                "Tipo: " + cliente.getTipoCliente()
                        + "\nCiudad: " + cliente.getCiudad()
                        + "\nFecha: " + cliente.getFechaNacimiento()
                        + "\nSolicitud: " + cliente.getTipoSolicitud()
        );
        alerta.showAndWait();
    }

    @FXML
    private void cerrarVentana() {
        Stage ventana = (Stage) tablaClientes.getScene().getWindow();
        ventana.close();
    }
}
