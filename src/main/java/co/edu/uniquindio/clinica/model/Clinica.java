package co.edu.uniquindio.clinica.model;

import java.util.ArrayList;

public class Clinica {
    private ArrayList<Medico> listamedicos;
    private ArrayList<Paciente> listapacientes;

    public Clinica() {
        this.listamedicos = new ArrayList<>();
        this.listapacientes = new ArrayList<>();
    }
    public ArrayList<Medico> getListamedicos() {
        return listamedicos;
    }
    public void setListamedicos(ArrayList<Medico> listamedicos) {
        this.listamedicos = listamedicos;
    }
    public ArrayList<Paciente> getListapacientes() {
        return listapacientes;
    }
    public void setListapacientes(ArrayList<Paciente> listapacientes) {
        this.listapacientes = listapacientes;
    }
}
