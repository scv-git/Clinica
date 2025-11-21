package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.facade.ClinicaFacade;
import co.edu.uniquindio.clinica.model.Paciente;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PacienteController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtTelefono;

    @FXML private TableView<Paciente> tablaPacientes;
    @FXML private TableColumn<Paciente, String> colNombre;
    @FXML private TableColumn<Paciente, String> colDocumento;
    @FXML private TableColumn<Paciente, String> colTelefono;

    private ClinicaFacade facade;

    @FXML
    public void initialize() {
        facade = new ClinicaFacade();

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("identifiacion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        tablaPacientes.setItems(facade.getPacientes());
    }

    @FXML
    private void onGuardarPaciente() {
        if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return;
        }

        facade.registrarPaciente(txtNombre.getText(), "", txtDocumento.getText(), txtTelefono.getText(), "", "");

        limpiarCampos();
        mostrarAlerta("Éxito", "Paciente registrado correctamente.", Alert.AlertType.INFORMATION);
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        txtTelefono.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
