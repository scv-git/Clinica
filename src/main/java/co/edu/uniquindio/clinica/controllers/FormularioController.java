package co.edu.uniquindio.clinica.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import co.edu.uniquindio.clinica.model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class FormularioController {

    @FXML private ComboBox<Medico> cbMedico;
    @FXML private ComboBox<Paciente> cbPaciente;
    @FXML private DatePicker dpFecha;
    @FXML private TextField txtHora;
    @FXML private TextField txtPrecio;
    @FXML private Button btnCancel;
    @FXML private Button btnSave;

    private Clinica clinica;
    private DashboardController dashboardController;

    @FXML
    public void initialize() {
        clinica = Clinica.getInstance();


        cbMedico.setItems(clinica.getListamedicos());
        cbPaciente.setItems(clinica.getListapacientes());


        txtPrecio.setText("$4.700");
        txtPrecio.setEditable(false);
    }

    @FXML
    private void onSaveCita() {

        if (!validarCampos())
            return;

        Medico medico = cbMedico.getValue();
        Paciente paciente = cbPaciente.getValue();
        LocalDate fecha = dpFecha.getValue();


        LocalTime hora;
        try {
            hora = LocalTime.parse(txtHora.getText().trim());
        } catch (Exception e) {
            mostrarAlerta("Error en la hora", "Formato de hora incorrecto. Ejemplo: 14:30", Alert.AlertType.ERROR);
            return;
        }

        Cita cita = new Cita.Builder()
                .setMedico(medico)
                .setPaciente(paciente)
                .setFecha(fecha)
                .setHora(hora)
                .build();

        clinica.agregarCita(cita); // <-- Se guarda en la clínica

        mostrarAlerta("Éxito", "Cita creada correctamente.", Alert.AlertType.INFORMATION);
        limpiarCampos();
    }


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

    private void limpiarCampos() {
        cbMedico.setValue(null);
        cbPaciente.setValue(null);
        dpFecha.setValue(null);
        txtHora.clear();
        txtPrecio.setText("$4.700"); // Restablecer precio
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
