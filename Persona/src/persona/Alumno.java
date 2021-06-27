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
        this.promedio = 0d;
        this.cantidadMateriasAprobadas = 0;
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

    public void setFechaIngreso(MiCalendario fechaIngreso) throws AlumnoException {
        if (fechaIngreso == null) {
            throw new AlumnoException("Se debe setear la fecha de Igreso");
        }
        if (fechaIngreso.before(fechaNacimiento)) {
            throw new AlumnoException("La fecha de Ingreso deber ser mayor a la fecha de Nacimineto");
        }
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getCantidadMateriasAprobadas() {
        return cantidadMateriasAprobadas;
    }

    public void setCantidadMateriasAprobadas(Integer cantidadMateriasAprobadas) throws AlumnoException {
        if (cantidadMateriasAprobadas < 0) {
            throw new AlumnoException("La cantidad de manterias aprobadas no puede ser menor a 0");
        }
        this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) throws AlumnoException {
        if (promedio < 0) {
            throw new AlumnoException("El promedio no puede ser menor a 0");
        }
        this.promedio = promedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setIsActivo(boolean isActivo) {
        activo = isActivo;
    }

    @Override
    public String toString() {
        return super.toString() + DELIM
                + fechaIngreso + DELIM
                + String.format("%2d", cantidadMateriasAprobadas) + DELIM
                + String.format("%5.2f", promedio) + DELIM
                + (activo ? 'A' : 'B');
    }
}
