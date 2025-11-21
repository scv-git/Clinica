package co.edu.uniquindio.clinica.model;

import java.util.Objects;

public class Medico {
    private String nombres;
    private String apellidos;
    private String identifiacion;
    private String especialidad; // opcional

    private Medico(Builder builder) {
        this.nombres = builder.nombres;
        this.identifiacion = builder.identifiacion;
        this.apellidos = builder.apellidos;
        this.especialidad = builder.especialidad;
    }

    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getIdentifiacion() { return identifiacion; }
    public String getEspecialidad() { return especialidad; }

    @Override
    public String toString() {
        return (nombres == null ? "" : nombres) + (apellidos == null ? "" : " " + apellidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medico)) return false;
        Medico medico = (Medico) o;
        return Objects.equals(identifiacion, medico.identifiacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiacion);
    }

    public static class Builder {
        private String nombres;
        private String identifiacion;
        private String apellidos;
        private String especialidad;

        public Builder setNombres(String nombres) { this.nombres = nombres; return this; }
        public Builder setIdentifiacion(String identifiacion) { this.identifiacion = identifiacion; return this; }
        public Builder setApellidos(String apellidos) { this.apellidos = apellidos; return this; }
        public Builder setEspecialidad(String especialidad) { this.especialidad = especialidad; return this; }

        public Medico build() { return new Medico(this); }
    }
}
