package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.model.Clinica;
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
    @FXML private TableColumn<Cita, String> colFecha;
    @FXML private TableColumn<Cita, String> colHora;

    private Clinica clinica;
    private DashboardController dashboardController;

    public void initialize() {
        clinica = Clinica.getInstance();

        comboMedicos.setItems(clinica.getListamedicos());

        colPaciente.setCellValueFactory(new PropertyValueFactory<>("pacienteNombre"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));

        tablaCitas.setItems(clinica.getListaCitas());
    }

    @FXML
    private void onMedicoSeleccionado() {
        Medico medicoSeleccionado = comboMedicos.getSelectionModel().getSelectedItem();
        if (medicoSeleccionado == null) return;

        var citasFiltradas = clinica.getListaCitas().filtered(
                c -> c.getMedico().equals(medicoSeleccionado)
        );

        tablaCitas.setItems(citasFiltradas);
    }

    @FXML
    private void onGuardarMedico() {

        if (txtNombreMedico.getText().isEmpty() ||
                txtApellido.getText().isEmpty() ||
                txtIdentificación.getText().isEmpty()) {

            mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return;
        }

        Medico medico = new Medico.Builder()
                .setNombres(txtNombreMedico.getText())
                .setApellidos(txtApellido.getText())
                .setIdentifiacion(txtIdentificación.getText())
                .build();

        clinica.agregarMedico(medico);

        comboMedicos.setItems(clinica.getListamedicos());

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

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }
}
