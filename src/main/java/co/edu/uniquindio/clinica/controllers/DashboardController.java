package co.edu.uniquindio.clinica.controllers;

import java.io.IOException;

import co.edu.uniquindio.clinica.model.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class DashboardController {

    @FXML private BorderPane mainContainer;
    @FXML private StackPane contentArea;

    @FXML private Button btnGoToForm;
    @FXML private Button btnGoToList;
    @FXML private Button btnGoToPaciente;
    @FXML private Button btnGoToMedico;

    @FXML
    public void initialize() {
        onGoToDashboard();
    }

    // ➤ Ir a la vista de citas
    @FXML
    private void onGoToForm() {
        loadView("/co/edu/uniquindio/clinica/FormularioCitas.fxml", "formulario");
    }


    @FXML
    private void onGoToPaciente() {
        loadView("/co/edu/uniquindio/clinica/Paciente.fxml", "paciente");
    }

    // ➤ Ir a la vista de médico
    @FXML
    private void onGoToMedico() {
        loadView("/co/edu/uniquindio/clinica/Medico.fxml", "medico");
    }

    // ➤ Vista principal
    @FXML
    private void onGoToDashboard() {
        contentArea.getChildren().clear();
        Label mensaje = new Label("Bienvenido al sistema de gestión de Citas Médicas");
        mensaje.setStyle("-fx-font-size: 24px; -fx-text-fill: #555;");
        contentArea.getChildren().add(mensaje);
    }

    public void backToDashboard() {
        onGoToDashboard();
    }



    private void loadView(String fxmlPath, String typeView) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
            Parent view = loader.load();

            switch (typeView) {
                case "formulario" -> {
                    FormularioController controller = loader.getController();
                    controller.setDashboardController(this);
                }
                case "paciente" -> {
                    PacienteController controller = loader.getController();
                    controller.setDashboardController(this);
                }
                case "medico" -> {
                    MedicoController controller = loader.getController();
                    controller.setDashboardController(this);
                }
                default -> throw new IllegalArgumentException("Vista no reconocida: " + typeView);
            }

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
