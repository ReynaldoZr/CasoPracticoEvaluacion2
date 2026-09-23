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
    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, String> columnaNombre;
    @FXML private TableColumn<Cliente, String> columnaTipo;
    @FXML private TableColumn<Cliente, String> columnaCiudad;
    @FXML private TableColumn<Cliente, LocalDate> columnaFecha;
    @FXML private TableColumn<Cliente, String> columnaSolicitud;

    private final ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        columnaNombre.setCellValueFactory(d -> new ReadOnlyStringWrapper(d.getValue().getNombreCompleto()));
        columnaTipo.setCellValueFactory(d -> new ReadOnlyStringWrapper(d.getValue().getTipoCliente()));
        columnaCiudad.setCellValueFactory(d -> new ReadOnlyStringWrapper(d.getValue().getCiudad()));
        columnaFecha.setCellValueFactory(d -> new ReadOnlyObjectWrapper<>(d.getValue().getFechaNacimiento()));
        columnaSolicitud.setCellValueFactory(d -> new ReadOnlyStringWrapper(d.getValue().getTipoSolicitud()));

        clientes.add(new Cliente("Ana", "López", "Frecuente", "Managua",
                LocalDate.of(2002, 5, 10), "Soporte técnico"));
        clientes.add(new Cliente("Carlos", "Ruiz", "Nuevo", "Masaya",
                LocalDate.of(1998, 11, 23), "Instalación"));
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
        Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
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
        alerta.setContentText("Tipo: " + cliente.getTipoCliente()
                + "\nCiudad: " + cliente.getCiudad()
                + "\nFecha: " + cliente.getFechaNacimiento()
                + "\nSolicitud: " + cliente.getTipoSolicitud());
        alerta.showAndWait();
    }

    @FXML
    private void cerrarVentana() {
        ((Stage) tablaClientes.getScene().getWindow()).close();
    }
}
