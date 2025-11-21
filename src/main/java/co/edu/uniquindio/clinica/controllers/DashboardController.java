package co.edu.uniquindio.clinica.controllers;

import java.io.IOException;

import co.edu.uniquindio.clinica.model.HelloApplication;
import javafx.event.ActionEvent;
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

    @FXML
    public void initialize() {
        onGoToDashboard();
    }

    @FXML
    private void onGoToForm() {
        loadView("/resources/FormularioCitas.fxml", "formulario");
    }



    @FXML
    private void onGoToDashboard() {
        contentArea.getChildren().clear();
        contentArea.getChildren().add(new Label("Bienvenido al sistema de gestión de Citas Médicas"));
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

            }

            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);

        } catch (IOException e) {
            showAlert("Error", "No se pudo cargar la vista: " + typeView, Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
    @FXML
    private void onGoToList(ActionEvent event) {
        System.out.println("Ir a lista...");
        // Aquí después cargas la nueva vista si quieres
    }


    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
