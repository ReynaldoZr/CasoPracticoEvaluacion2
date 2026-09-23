package ni.uam.edu.evaluacion2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class RegistroClienteController {

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private ComboBox<String> cbTipoCliente;

    @FXML
    private ComboBox<String> cbCiudad;

    @FXML
    private DatePicker dpFechaNacimiento;

    @FXML
    private RadioButton rbAfiliacion;

    @FXML
    private RadioButton rbConsulta;

    @FXML
    private RadioButton rbReclamo;

    @FXML
    private CheckBox chkInternet;

    @FXML
    private CheckBox chkTelefonia;

    @FXML
    private CheckBox chkCable;

    @FXML
    private CheckBox chkSoporteTecnico;

    @FXML
    private ImageView imgFotografia;

    private ToggleGroup grupoSolicitud;

    private File archivoFotografia;


    @FXML
    public void initialize() {

        cbTipoCliente.getItems().addAll(
                "Regular",
                "Preferencial",
                "Empresarial"
        );

        cbCiudad.getItems().addAll(
                "Managua",
                "Masaya",
                "Granada",
                "León",
                "Chinandega",
                "Estelí",
                "Matagalpa"
        );

        grupoSolicitud = new ToggleGroup();

        rbAfiliacion.setToggleGroup(grupoSolicitud);
        rbConsulta.setToggleGroup(grupoSolicitud);
        rbReclamo.setToggleGroup(grupoSolicitud);
    }


    @FXML
    private void seleccionarFotografia() {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Seleccionar fotografía");

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Imágenes",
                        "*.png",
                        "*.jpg",
                        "*.jpeg"
                )
        );

        archivoFotografia = fileChooser.showOpenDialog(
                imgFotografia.getScene().getWindow()
        );

        if (archivoFotografia != null) {

            Image imagen = new Image(
                    archivoFotografia.toURI().toString()
            );

            imgFotografia.setImage(imagen);
        }
    }


    @FXML
    private void guardar() {

        if (txtNombres.getText().trim().isEmpty()) {
            mostrarAlerta("Debe ingresar los nombres.");
            return;
        }

        if (txtApellidos.getText().trim().isEmpty()) {
            mostrarAlerta("Debe ingresar los apellidos.");
            return;
        }

        if (cbTipoCliente.getValue() == null) {
            mostrarAlerta("Debe seleccionar el tipo de cliente.");
            return;
        }

        if (cbCiudad.getValue() == null) {
            mostrarAlerta("Debe seleccionar una ciudad.");
            return;
        }

        if (dpFechaNacimiento.getValue() == null) {
            mostrarAlerta("Debe seleccionar la fecha de nacimiento.");
            return;
        }

        if (grupoSolicitud.getSelectedToggle() == null) {
            mostrarAlerta("Debe seleccionar el tipo de solicitud.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Cliente registrado");
        alert.setHeaderText(null);
        alert.setContentText("Cliente registrado correctamente.");

        alert.showAndWait();
    }


    @FXML
    private void limpiar() {

        txtNombres.clear();
        txtApellidos.clear();

        cbTipoCliente.getSelectionModel().clearSelection();
        cbCiudad.getSelectionModel().clearSelection();

        dpFechaNacimiento.setValue(null);

        grupoSolicitud.selectToggle(null);

        chkInternet.setSelected(false);
        chkTelefonia.setSelected(false);
        chkCable.setSelected(false);
        chkSoporteTecnico.setSelected(false);

        imgFotografia.setImage(null);

        archivoFotografia = null;
    }


    @FXML
    private void cancelar() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Cancelar");
        alert.setHeaderText(null);
        alert.setContentText("¿Desea cancelar el registro?");

        if (alert.showAndWait().get() == ButtonType.OK) {

            Stage ventana = (Stage) txtNombres
                    .getScene()
                    .getWindow();

            ventana.close();
        }
    }


    private void mostrarAlerta(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}