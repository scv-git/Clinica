module co.edu.uniquindio.clinica {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens co.edu.uniquindio.clinica to javafx.fxml;
    exports co.edu.uniquindio.clinica.model;
    opens co.edu.uniquindio.clinica.controllers to javafx.fxml;
    exports co.edu.uniquindio.clinica.controllers;

}