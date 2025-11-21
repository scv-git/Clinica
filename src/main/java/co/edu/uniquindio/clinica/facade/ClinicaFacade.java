package co.edu.uniquindio.clinica.facade;

import co.edu.uniquindio.clinica.factory.EntidadFactory;
import co.edu.uniquindio.clinica.model.Cita;
import co.edu.uniquindio.clinica.model.Clinica;
import co.edu.uniquindio.clinica.model.Medico;
import co.edu.uniquindio.clinica.model.Paciente;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalTime;


public class ClinicaFacade {

    private final Clinica clinica = Clinica.getInstance();


    public void registrarMedico(String nombre, String apellido, String id, String especialidad) {
        Medico m = EntidadFactory.crearMedico(nombre, apellido, id, especialidad);
        clinica.agregarMedico(m);
    }

    public ObservableList<Medico> getMedicos() {
        return clinica.getListamedicos();
    }


    public void registrarPaciente(String nombre, String apellido, String documento, String telefono, String direccion, String email) {
        Paciente p = EntidadFactory.crearPaciente(nombre, apellido, documento, telefono, direccion, email);
        clinica.agregarPaciente(p);
    }

    public ObservableList<Paciente> getPacientes() {
        return clinica.getListapacientes();
    }


    public void registrarCita(Medico medico, Paciente paciente, LocalDate fecha, LocalTime hora, double precio) {
        Cita c = EntidadFactory.crearCita(medico, paciente, fecha, hora, precio);
        clinica.agregarCita(c);
    }

    public ObservableList<Cita> getCitas() {
        return clinica.getListaCitas();
    }

    public ObservableList<Cita> getCitasPorMedico(Medico medico) {
        return clinica.getListaCitas().filtered(c -> c.getMedico().equals(medico));
    }
}
