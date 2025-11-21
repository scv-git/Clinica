package co.edu.uniquindio.clinica.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import co.edu.uniquindio.clinica.model.Cita;
import co.edu.uniquindio.clinica.model.Medico;
import co.edu.uniquindio.clinica.model.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private TextField txtPrecio; // (si agregas precio)

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    private DashboardController dashboardController;
    @FXML
    public void initialize() {
        cargarMedicos();
        cargarPacientes();
    }

    // -----------------------------------------------------
    //   Cargar datos iniciales (PRUEBA) (puedes reemplazar)
    // -----------------------------------------------------
    private void cargarMedicos() {
        cbMedico.getItems().addAll(
                new Medico.Builder()
                        .setNombres("Carlos")
                        .setApellidos("Pérez")
                        .setIdentifiacion("M001")
                        .build(),

                new Medico.Builder()
                        .setNombres("Ana")
                        .setApellidos("López")
                        .setIdentifiacion("M002")
                        .build()
        );
    }

    private void cargarPacientes() {
        cbPaciente.getItems().addAll(
                new Paciente.Builder()
                        .setNombres("Juan")
                        .setApellidos("Martínez")
                        .setIdentifiacion("P001")
                        .setTelefono("3100000000")
                        .setdireccion("Calle 123")
                        .setEmail("juan@email.com")
                        .build(),

                new Paciente.Builder()
                        .setNombres("María")
                        .setApellidos("Rodríguez")
                        .setIdentifiacion("P002")
                        .setTelefono("3200000000")
                        .setdireccion("Cra 10")
                        .setEmail("maria@email.com")
                        .build()
        );
    }

    // -----------------------------------------------------
    //               Guardar Cita
    // -----------------------------------------------------
    @FXML
    private void onSaveCita() {

        if (!validarCampos())
            return;

        Medico medico = cbMedico.getValue();
        Paciente paciente = cbPaciente.getValue();
        LocalDate fecha = dpFecha.getValue();

        // Convertir texto a LocalTime
        LocalTime hora;
        try {
            hora = LocalTime.parse(txtHora.getText().trim());
        } catch (Exception e) {
            mostrarAlerta("Error en la hora", "Formato de hora incorrecto. Ejemplo: 14:30", Alert.AlertType.ERROR);
            return;
        }

        // Crear la cita usando tu Builder REAL
        Cita cita = new Cita.Builder()
                .setMedico(medico)
                .setPaciente(paciente)
                .setFecha(fecha)
                .setHora(hora)
                .build();

        mostrarAlerta("Éxito", "Cita creada correctamente.", Alert.AlertType.INFORMATION);

        cerrarVentana();
    }

    // -----------------------------------------------------
    //               Validación de campos
    // -----------------------------------------------------
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
            mostrarAlerta("Validación", "Debe ingresar la hora (Ej: 14:30).", Alert.AlertType.WARNING);
            return false;
        }

        return true;
    }

    // -----------------------------------------------------
    //                   Botón Cancelar
    // -----------------------------------------------------
    @FXML
    private void onCancel() {
        cerrarVentana();
    }

    // -----------------------------------------------------
    //               Métodos útiles
    // -----------------------------------------------------
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

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }
}
