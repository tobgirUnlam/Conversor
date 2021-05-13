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
    
    public static final String DELIM = "\t";
    
    private long dni;

    private String nombre;

    private String apellido;

    protected MiCalendario fechaNacimiento;
	
	private char sexo;

    public Persona() {

    }

    public Persona(long dni) throws PersonaException {
        setDni(dni);
    }

    public Persona(long dni, String nombre, String apellido) throws PersonaException {
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
    }
	
    public Persona(long dni, String nombre, String apellido, MiCalendario fechaNacimiento, char sexo) throws PersonaException {
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        setFechaNacimiento(fechaNacimiento);
		setSexo(sexo);	
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
        this.apellido = apellido;
    }

    public MiCalendario getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(MiCalendario fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) throws PersonaException {
        sexo = Character.toUpperCase(sexo);
        if (sexo!='F' && sexo!='M') {
            throw new PersonaException("El sexo debe ser F o M (o f o m)"); 
        }
        this.sexo = sexo;        
        
    }

    @Override
    public String toString() {
        String nombreStr = nombre.length()>20?nombre.substring(0, 20):nombre;
        
        return String.format("%8d", dni) + DELIM +
                String.format("%20s", nombreStr) + DELIM +
                String.format("%15s", apellido) + DELIM +
                fechaNacimiento + DELIM +
                sexo;
    }
    
}
