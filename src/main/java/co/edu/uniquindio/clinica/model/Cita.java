package co.edu.uniquindio.clinica.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private Medico medico;
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime hora;

    private Cita(Builder builder) {
        this.medico = builder.medico;
        this.paciente = builder.paciente;
        this.fecha = builder.fecha;
        this.hora = builder.hora;
    }

    static class Builder {
        private Medico medico;
        private Paciente paciente;
        private LocalDate fecha;
        private LocalTime hora;

        public Builder setMedico(Medico medico) {
            this.medico = medico;
            return this;
        }

        public Builder setPaciente(Paciente paciente) {
            this.paciente = paciente;
            return this;
        }

        public Builder setFecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder setHora(LocalTime hora) {
            this.hora = hora;
            return this;
        }

        public Cita build() {
            return new Cita(this);
        }
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
}
