package co.edu.uniquindio.clinica.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/view/DashBoardController.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("Sistema de Gestión de Productos");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(500);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


