package co.edu.uniquindio.poo.controllers;

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

    @FXML
    public void initialize() { }

    @FXML
    private void onGoToForm() {
        loadView("/view/FormularioController.fxml", "formulario");
    }

    @FXML
    private void onGoToList() {
        loadView("/view/ListadoController.fxml", "listado");
    }

    @FXML
    private void onGoToDashboard() {
        contentArea.getChildren().clear();
        contentArea.getChildren().add(new Label("Bienvenido al sistema de gestión de Inmuebles"));
    }

    void backToDashboard() {
        onGoToDashboard();
    }

    private void loadView(String fxmlPath, String typeView) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
            Parent view = loader.load();

            if (typeView.equals("formulario")) {
                FormularioController controller = loader.getController();
                controller.setDashboardController(this);
            } else if (typeView.equals("listado")) {
                ListadoController controller = loader.getController();
                controller.setDashboardController(this);
                controller.loadInmuebles();
            }

            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);

        } catch (IOException e) {
            showAlert("Error", "No se pudo cargar la vista: " + typeView, Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alerta = new Alert(type);
        alerta.setTitle(title);
        alerta.setHeaderText(null);
        alerta.setContentText(message);
        alerta.showAndWait();
    }
}
