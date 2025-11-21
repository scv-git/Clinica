package co.edu.uniquindio.clinica.factory;

import co.edu.uniquindio.clinica.model.Cita;
import co.edu.uniquindio.clinica.model.Medico;
import co.edu.uniquindio.clinica.model.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;


public class EntidadFactory {

    public static Medico crearMedico(String nombre, String apellido, String id, String especialidad) {
        return new Medico.Builder()
                .setNombres(nombre)
                .setApellidos(apellido)
                .setIdentifiacion(id)
                .setEspecialidad(especialidad)
                .build();
    }

    public static Paciente crearPaciente(String nombre, String apellido, String documento, String telefono, String direccion, String email) {
        return new Paciente.Builder()
                .setNombres(nombre)
                .setApellidos(apellido)
                .setIdentifiacion(documento)
                .setTelefono(telefono)
                .setdireccion(direccion)
                .setEmail(email)
                .build();
    }

    public static Cita crearCita(Medico medico, Paciente paciente, LocalDate fecha, LocalTime hora, double precio) {
        return new Cita.Builder()
                .setMedico(medico)
                .setPaciente(paciente)
                .setFecha(fecha)
                .setHora(hora)
                .setPrecio(precio)
                .build();
    }
}
