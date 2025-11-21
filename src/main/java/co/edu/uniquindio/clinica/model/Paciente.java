package co.edu.uniquindio.clinica.model;

import java.util.Objects;

public class Paciente {
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String identifiacion;
    private String email;

    private Paciente(Builder builder) {
        this.nombres = builder.nombres;
        this.identifiacion = builder.identifiacion;
        this.apellidos = builder.apellidos;
        this.telefono = builder.telefono;
        this.direccion = builder.direccion;
        this.email = builder.email;
    }

    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public String getIdentifiacion() { return identifiacion; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return (nombres == null ? "" : nombres) + (apellidos == null ? "" : " " + apellidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(identifiacion, paciente.identifiacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiacion);
    }

    public static class Builder {
        private String nombres;
        private String identifiacion;
        private String apellidos;
        private String telefono;
        private String direccion;
        private String email;

        public Builder setNombres(String nombres) { this.nombres = nombres; return this; }
        public Builder setIdentifiacion(String identifiacion) { this.identifiacion = identifiacion; return this; }
        public Builder setTelefono(String telefono) { this.telefono = telefono; return this; }
        public Builder setdireccion(String direccion) { this.direccion = direccion; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setApellidos(String apellidos) { this.apellidos = apellidos; return this; }

        public Paciente build() { return new Paciente(this); }
    }
}
