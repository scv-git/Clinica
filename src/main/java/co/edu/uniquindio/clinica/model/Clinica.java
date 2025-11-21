package co.edu.uniquindio.clinica.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class Clinica {

    private static Clinica instance;

    private final ObservableList<Medico> listamedicos;
    private final ObservableList<Paciente> listapacientes;
    private final ObservableList<Cita> listaCitas;

    private Clinica() {
        listamedicos = FXCollections.observableArrayList();
        listapacientes = FXCollections.observableArrayList();
        listaCitas = FXCollections.observableArrayList();
    }

    public static Clinica getInstance() {
        if (instance == null) {
            instance = new Clinica();
        }
        return instance;
    }

    public ObservableList<Medico> getListamedicos() { return listamedicos; }
    public ObservableList<Paciente> getListapacientes() { return listapacientes; }
    public ObservableList<Cita> getListaCitas() { return listaCitas; }

    public void agregarMedico(Medico m) { listamedicos.add(m); }
    public void agregarPaciente(Paciente p) { listapacientes.add(p); }
    public void agregarCita(Cita c) { listaCitas.add(c); }
}
