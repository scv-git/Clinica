package co.edu.uniquindio.clinica.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Cita {
    private Medico medico;
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime hora;
    private double precio; // agregado para Factory / futuro uso

    private Cita(Builder builder) {
        this.medico = builder.medico;
        this.paciente = builder.paciente;
        this.fecha = builder.fecha;
        this.hora = builder.hora;
        this.precio = builder.precio;
    }

    public Medico getMedico() { return medico; }
    public Paciente getPaciente() { return paciente; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public double getPrecio() { return precio; }

    public String getPacienteNombre() {
        if (paciente == null) return "";
        return (paciente.getNombres() == null ? "" : paciente.getNombres()) +
                (paciente.getApellidos() == null ? "" : " " + paciente.getApellidos());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cita)) return false;
        Cita cita = (Cita) o;
        return Objects.equals(medico, cita.medico) &&
                Objects.equals(paciente, cita.paciente) &&
                Objects.equals(fecha, cita.fecha) &&
                Objects.equals(hora, cita.hora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medico, paciente, fecha, hora);
    }

    public static class Builder {
        private Medico medico;
        private Paciente paciente;
        private LocalDate fecha;
        private LocalTime hora;
        private double precio;

        public Builder setMedico(Medico medico) { this.medico = medico; return this; }
        public Builder setPaciente(Paciente paciente) { this.paciente = paciente; return this; }
        public Builder setFecha(LocalDate fecha) { this.fecha = fecha; return this; }
        public Builder setHora(LocalTime hora) { this.hora = hora; return this; }
        public Builder setPrecio(double precio) { this.precio = precio; return this; }

        public Cita build() { return new Cita(this); }
    }
}
