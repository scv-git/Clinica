module co.edu.uniquindio.clinica {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.clinica to javafx.fxml;
    exports co.edu.uniquindio.clinica.model;
    opens co.edu.uniquindio.clinica.model to javafx.fxml;
    exports co.edu.uniquindio.clinica.controllers;
    opens co.edu.uniquindio.clinica.controllers to javafx.fxml;
}