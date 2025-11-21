package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.facade.ClinicaFacade;
import co.edu.uniquindio.clinica.model.Medico;
import co.edu.uniquindio.clinica.model.Paciente;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalTime;

public class FormularioController {

    @FXML private ComboBox<Medico> cbMedico;
    @FXML private ComboBox<Paciente> cbPaciente;
    @FXML private DatePicker dpFecha;
    @FXML private TextField txtHora;
    @FXML private TextField txtPrecio;
    @FXML private Button btnCancel;
    @FXML private Button btnSave;

    private ClinicaFacade facade;

    @FXML
    public void initialize() {
        facade = new ClinicaFacade();

        cbMedico.setItems(facade.getMedicos());
        cbPaciente.setItems(facade.getPacientes());

        txtPrecio.setText("$4.700");
        txtPrecio.setEditable(false);
    }

    @FXML
    private void onSaveCita() {
        if (cbMedico.getValue() == null || cbPaciente.getValue() == null || dpFecha.getValue() == null || txtHora.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return;
        }

        LocalTime hora;
        try {
            hora = LocalTime.parse(txtHora.getText().trim());
        } catch (Exception e) {
            mostrarAlerta("Error en la hora", "Formato de hora incorrecto. Ejemplo: 14:30", Alert.AlertType.ERROR);
            return;
        }

        double precio = 4700.0; // fijo por ahora
        facade.registrarCita(cbMedico.getValue(), cbPaciente.getValue(), dpFecha.getValue(), hora, precio);

        mostrarAlerta("Éxito", "Cita creada correctamente.", Alert.AlertType.INFORMATION);
        limpiarCampos();
    }

    private void limpiarCampos() {
        cbMedico.setValue(null);
        cbPaciente.setValue(null);
        dpFecha.setValue(null);
        txtHora.clear();
        txtPrecio.setText("$4.700");
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
