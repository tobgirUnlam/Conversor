/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

/**
 *
 * @author Tobias
 */
public class Alumno extends Persona {

    private MiCalendario fechaIngreso;

    private Integer cantidadMateriasAprobadas;

    private Double promedio;

    private boolean activo = true;

    public Alumno() {
        super();
    }

    public Alumno(MiCalendario fechaIngreso, Integer cantidadMateriasAprobadas, Double promedio) {
        this.fechaIngreso = fechaIngreso;
        this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
        this.promedio = promedio;
    }

    public Alumno(long dni, MiCalendario fechaIngreso, Integer cantidadMateriasAprobadas, Double promedio) throws PersonaException {
        super(dni);
        this.fechaIngreso = fechaIngreso;
        this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
        this.promedio = promedio;
    }

    public Alumno(long dni, String nombre, String apellido, MiCalendario fechaIngreso, Integer cantidadMateriasAprobadas, Double promedio)
            throws PersonaException {
        super(dni, nombre, apellido);
        this.fechaIngreso = fechaIngreso;
        this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
        this.promedio = promedio;
    }

    public Alumno(long dni, String nombre, String apellido, MiCalendario fechaNac, MiCalendario fechaIngreso,
            Integer cantidadMateriasAprobadas, Double promedio, char sexo, boolean activo)
            throws PersonaException {
        super(dni, nombre, apellido, fechaNac, sexo);
        setFechaIngreso(fechaIngreso);
        this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
        this.promedio = promedio;
        this.activo = activo;

    }

    public MiCalendario getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(MiCalendario fechaIngreso) throws AlumnoException{
        if (fechaNacimiento==null) {
            throw new AlumnoException("Se debe setear la fecha de Nacimiento");
        }
        if (fechaIngreso.before(fechaNacimiento)) {
            throw new AlumnoException("La fecha de Ingreso deber ser mayor a la fecha de Nacimineto");
        }
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getCantidadMateriasAprobadas() {
        return cantidadMateriasAprobadas;
    }

    public void setCantidadMateriasAprobadas(Integer cantidadMateriasAprobadas) {
        // TODO validar negativos (lanzar AlumnoException("..."))
        this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    public boolean isActivo(){
        return activo;
    }
    public void setIsActivo(boolean isActivo){
        activo = isActivo;
    }
    
    @Override
    public String toString() {
        return super.toString() + DELIM +
                fechaIngreso + DELIM + 
                String.format("%2d", cantidadMateriasAprobadas) + DELIM +
                String.format("%5.2f", promedio) + DELIM +
                (activo?'A':'B');
    }
}
