package org.example.evaluacion2;

import java.time.LocalDate;

public class RegistroCliente {
    private final String nombres;
    private final String apellidos;
    private final String tipoCliente;
    private final String ciudad;
    private final LocalDate fechaNacimiento;
    private final String tipoSolicitud;

    public RegistroCliente(String nombres, String apellidos, String tipoCliente,
                           String ciudad, LocalDate fechaNacimiento, String tipoSolicitud) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoCliente = tipoCliente;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }
}
