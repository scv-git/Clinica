package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.facade.ClinicaFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class DashboardController {

    @FXML private StackPane contentArea;
    @FXML private Button btnGoToForm;
    @FXML private Button btnGoToPaciente;
    @FXML private Button btnGoToMedico;

    private ClinicaFacade facade;

    @FXML
    public void initialize() {
        facade = new ClinicaFacade();
        onGoToDashboard();
    }

    @FXML
    private void onGoToForm() {
        loadView("/co/edu/uniquindio/clinica/FormularioCitas.fxml", "formulario");
    }

    @FXML
    private void onGoToPaciente() {
        loadView("/co/edu/uniquindio/clinica/Paciente.fxml", "paciente");
    }

    @FXML
    private void onGoToMedico() {
        loadView("/co/edu/uniquindio/clinica/Medico.fxml", "medico");
    }

    @FXML
    private void onGoToDashboard() {
        contentArea.getChildren().clear();
        Label mensaje = new Label("Bienvenido al sistema de gestión de Citas Médicas");
        mensaje.setStyle("-fx-font-size: 20px; -fx-text-fill: #333;");
        contentArea.getChildren().add(mensaje);
    }

    private void loadView(String fxmlPath, String typeView) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();

            // si necesitas pasar referencias, hazlo aquí
            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);

        } catch (IOException e) {
            showAlert("Error", "No se pudo cargar la vista: " + typeView, Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
