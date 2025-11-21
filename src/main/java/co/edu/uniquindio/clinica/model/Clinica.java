package co.edu.uniquindio.clinica.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Clinica {

    private ObservableList<Medico> listamedicos;
    private ObservableList<Paciente> listapacientes;
    private ObservableList<Cita> listaCitas;

    private static Clinica instancia;

    private Clinica() {
        listamedicos = FXCollections.observableArrayList();
        listapacientes = FXCollections.observableArrayList();
        listaCitas = FXCollections.observableArrayList();
    }

    public static Clinica getInstance() {
        if (instancia == null) instancia = new Clinica();
        return instancia;
    }

    public ObservableList<Medico> getListamedicos() { return listamedicos; }
    public ObservableList<Paciente> getListapacientes() { return listapacientes; }
    public ObservableList<Cita> getListaCitas() { return listaCitas; }

    public void agregarMedico(Medico m) { listamedicos.add(m); }
    public void agregarPaciente(Paciente p) { listapacientes.add(p); }
    public void agregarCita(Cita c) { listaCitas.add(c); }
}
