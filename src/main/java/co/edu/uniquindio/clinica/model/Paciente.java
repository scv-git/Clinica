package co.edu.uniquindio.clinica.model;

public class Paciente {
   private String nombres;
   private String apellidos;
   private String telefono;
   private String direccion;
   private String identifiacion;
   private String email;

    private Paciente(Paciente.Builder builder) {
        this.nombres = builder.nombres;
        this.identifiacion = builder.identifiacion;
        this.apellidos= builder.apellidos;
        this.telefono=builder.telefono;
        this.direccion=builder.direccion;
        this.email=builder.email;

    }
    public String getNombres() { return nombres; }

    public String getApellidos() { return apellidos; }

    public String getTelefono() { return telefono; }

    public String getDireccion() { return direccion; }

    public String getIdentifiacion() { return identifiacion; }

    public String getEmail() { return email; }

    public static class Builder {
        private String nombres;
        private String identifiacion;
        private String apellidos;
        private String telefono;
        private String direccion;
        private String email;

        public Paciente.Builder setNombres(String nombres) {
            this.nombres = nombres;
            return this;
        }

        public  Paciente.Builder setIdentifiacion(String identifiacion) {
            this.identifiacion = identifiacion;
            return this;
        }
        public Paciente.Builder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }
        public Paciente.Builder setdireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }
        public Paciente.Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Paciente.Builder setApellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public Paciente build() {
            return new Paciente(this);
        }
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }


}
