/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.Date;

/**
 *
 * @author Tobias
 */
public class Persona {

    private long dni;

    private String nombre;

    private String apellido;

    private MiCalendario fechaNacimiento;

    public Persona() {

    }

    public Persona(long dni) throws PersonaException {
        setDni(dni);
    }

    public Persona(long dni, String nombre, String apellido, MiCalendario fechaNacimiento) throws PersonaException {
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        setFechaNac(fechaNacimiento);
    }

    public Persona(long dni, String nombre, String apellido) throws PersonaException {
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) throws PersonaException {
        if (dni <= 0) {
            throw new PersonaException("El DNI debe ser positivo (" + dni + ")");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws PersonaException {
        if (nombre == null || nombre.trim().equals("")) {
            throw new PersonaException("Debe indicar el nombre de la persona");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws PersonaException {
        if (apellido == null || apellido.trim().equals("")) {
            throw new PersonaException("Debe indicar el apellido de la persona");
        }
        setApellido(apellido);
    }

    public MiCalendario getFechaNac() {
        return fechaNacimiento;
    }

    public void setFechaNac(MiCalendario fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
