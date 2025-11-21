package co.edu.uniquindio.clinica.model;

public class Medico {
    private String nombres;
    private String apellidos;
    private String identifiacion;

    private Medico(Builder builder) {
        this.nombres = builder.nombres;
        this.identifiacion = builder.identifiacion;
        this.apellidos= builder.apellidos;
    }
    public String getNombres() { return nombres; }

    public String getApellidos() { return apellidos; }


    public String getIdentifiacion() { return identifiacion; }


    public static class Builder {
        private String nombres;
        private String identifiacion;
        private String apellidos;

        public Builder setNombres(String nombres) {
            this.nombres = nombres;
            return this;
        }

        public Builder setIdentifiacion(String identifiacion) {
            this.identifiacion = identifiacion;
            return this;
        }
        public Builder setApellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }


        public Medico build() {
            return new Medico(this);
        }
    }
    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }

}
