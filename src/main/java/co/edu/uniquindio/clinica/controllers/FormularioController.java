package co.edu.uniquindio.poo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import co.edu.uniquindio.clinica.model.Cita;
import co.edu.uniquindio.clinica.model.Medico;
import co.edu.uniquindio.clinica.model.Paciente;

import java.time.LocalDate;

public class FormularioController {

    @FXML
    private ComboBox<Medico> cbMedico;

    @FXML
    private ComboBox<Paciente> cbPaciente;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    public void initialize() {
        cargarMedicos();
        cargarPacientes();
    }

    // -----------------------------------------------------------
    //        MÉTODOS PARA CARGAR DATOS INICIALES
    // -----------------------------------------------------------

    private void cargarMedicos() {
        // Aquí debes cargar tus médicos reales
        cbMedico.getItems().addAll(
                new Medico("M001", "Carlos Pérez"),
                new Medico("M002", "Ana López")
        );
    }

    private void cargarPacientes() {
        // Aquí debes cargar tus pacientes reales
        cbPaciente.getItems().addAll(
                new Paciente("P001", "Juan Martínez"),
                new Paciente("P002", "María Rodríguez")
        );
    }

    // -----------------------------------------------------------
    //                 BOTÓN GUARDAR CITA
    // -----------------------------------------------------------

    @FXML
    private void onSaveCita() {
        try {
            // Validar campos
            if (!validarCampos()) {
                return;
            }

            Medico medico = cbMedico.getValue();
            Paciente paciente = cbPaciente.getValue();
            LocalDate fecha = dpFecha.getValue();
            String hora = txtHora.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            // Crear cita
            Cita cita = new Cita(medico, paciente, fecha, hora, precio);

            mostrarAlerta("Éxito", "Cita guardada correctamente.", Alert.AlertType.INFORMATION);

            cerrarVentana();

        } catch (Exception e) {
            mostrarAlerta("Error", "Ha ocurrido un error: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // -----------------------------------------------------------
    //                VALIDACIÓN DE CAMPOS
    // -----------------------------------------------------------

    private boolean validarCampos() {

        if (cbMedico.getValue() == null) {
            mostrarAlerta("Validación", "Debe seleccionar un médico.", Alert.AlertType.WARNING);
            return false;
        }

        if (cbPaciente.getValue() == null) {
            mostrarAlerta("Validación", "Debe seleccionar un paciente.", Alert.AlertType.WARNING);
            return false;
        }

        if (dpFecha.getValue() == null) {
            mostrarAlerta("Validación", "Debe seleccionar una fecha.", Alert.AlertType.WARNING);
            return false;
        }

        if (txtHora.getText().trim().isEmpty()) {
            mostrarAlerta("Validación", "Debe ingresar la hora.", Alert.AlertType.WARNING);
            return false;
        }

        if (txtPrecio.getText().trim().isEmpty()) {
            mostrarAlerta("Validación", "Debe ingresar un precio.", Alert.AlertType.WARNING);
            return false;
        }

        try {
            Double.parseDouble(txtPrecio.getText().trim());
        } catch (NumberFormatException e) {
            mostrarAlerta("Validación", "El precio debe ser un número.", Alert.AlertType.WARNING);
            return false;
        }

        return true;
    }

    // -----------------------------------------------------------
    //                  BOTÓN CANCELAR
    // -----------------------------------------------------------

    @FXML
    private void onCancel() {
        cerrarVentana();
    }

    // -----------------------------------------------------------
    //                     MÉTODOS UTILES
    // -----------------------------------------------------------

    private void cerrarVentana() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
