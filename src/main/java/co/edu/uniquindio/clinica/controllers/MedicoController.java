package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.facade.ClinicaFacade;
import co.edu.uniquindio.clinica.model.Cita;
import co.edu.uniquindio.clinica.model.Medico;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MedicoController {

    @FXML private TextField txtNombreMedico;
    @FXML private TextField txtApellido;
    @FXML private TextField txtIdentificación;

    @FXML private ComboBox<Medico> comboMedicos;

    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, String> colPaciente;
    @FXML private TableColumn<Cita, Object> colFecha;
    @FXML private TableColumn<Cita, Object> colHora;

    private ClinicaFacade facade;

    @FXML
    public void initialize() {
        facade = new ClinicaFacade();

        comboMedicos.setItems(facade.getMedicos());

        colPaciente.setCellValueFactory(new PropertyValueFactory<>("pacienteNombre"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));

        tablaCitas.setItems(facade.getCitas());
    }

    @FXML
    private void onMedicoSeleccionado() {
        Medico medicoSeleccionado = comboMedicos.getSelectionModel().getSelectedItem();
        if (medicoSeleccionado == null) {
            tablaCitas.setItems(facade.getCitas());
            return;
        }
        tablaCitas.setItems(facade.getCitasPorMedico(medicoSeleccionado));
    }

    @FXML
    private void onGuardarMedico() {
        if (txtNombreMedico.getText().isEmpty() || txtApellido.getText().isEmpty() || txtIdentificación.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return;
        }

        facade.registrarMedico(txtNombreMedico.getText(), txtApellido.getText(), txtIdentificación.getText(), "");
        comboMedicos.setItems(facade.getMedicos());
        limpiarCampos();
        mostrarAlerta("Éxito", "Médico registrado correctamente.", Alert.AlertType.INFORMATION);
    }

    private void limpiarCampos() {
        txtNombreMedico.clear();
        txtApellido.clear();
        txtIdentificación.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
