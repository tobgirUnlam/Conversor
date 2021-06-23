/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.MiCalendario;
import persona.MiCalendarioException;
import persona.PersonaException;

/**
 *
 * @author Tobias
 */
public class AlumnoDAOTXT extends DAO<Alumno, Long> {

    private RandomAccessFile raf;

    AlumnoDAOTXT(String filename) throws DAOException {
        try {
            raf = new RandomAccessFile(filename, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear el DAO ==> " + ex.getMessage());
        }
    }

    @Override
    public void create(Alumno alumno) throws DAOException {

        try {
            if (exists(alumno.getDni())) {
                throw new DAOException("El alumno ya existe");
            }

            raf.seek(raf.length()); // Va al final del archivo
            raf.writeBytes(alumno.toString() + System.lineSeparator());

        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear el alumno ==> " + ex.getMessage());
        }
    }

    @Override
    public Alumno read(Long dni) throws DAOException {

        try {
            raf.seek(0); // Se posiciona al inicio
            String linea;
            String[] campos;
            while ((linea = raf.readLine()) != null) {
                campos = linea.split(persona.Persona.DELIM);
                if (campos[0].trim().equals(String.valueOf(dni))) {
                    return str2Alu(campos);
                }
            }
        } catch (IOException | MiCalendarioException | PersonaException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al leer ==> " + ex.getMessage());
        }

        return null;
    }

    private Alumno str2Alu(String[] campos) throws NumberFormatException, PersonaException, MiCalendarioException {
        int i = 0;
        Long dni = Long.valueOf(campos[i++].trim());
        String nombre = campos[i++].trim();

        String apellido = campos[i++].trim();

        String[] fecha = campos[i++].split("/");
        MiCalendario fechaNacimiento = new MiCalendario(Integer.valueOf(fecha[0].trim()), Integer.valueOf(fecha[1].trim()), Integer.valueOf(fecha[2]));

        char sexo = campos[i++].charAt(0);

        fecha = campos[i++].split("/");
        MiCalendario fechaIngreso = new MiCalendario(Integer.valueOf(fecha[0].trim()), Integer.valueOf(fecha[1].trim()), Integer.valueOf(fecha[2]));

        Integer cantidadMateriasAprobadas = Integer.valueOf(campos[i++].trim());
        Double promedio = Double.valueOf(campos[i++].trim().replaceAll(",", "."));

        boolean activo = campos[i].equals("A");

        return new Alumno(dni, nombre, apellido, fechaNacimiento, fechaIngreso, cantidadMateriasAprobadas, promedio, sexo, activo);
    }

    /**
     *
     * @param entidad
     * @throws DAOException
     */
    @Override
    public void update(Alumno entidad) throws DAOException {
        try {
            //para poder actualizar el registro, debo obtener la posición inicial del puntero y sobreescribir.
            //Modificar iterando linea por linea y si encontramos el DNI escribimos.
            long longitudActualDelRegistro = this.read(entidad.getDni()).toString().length() + System.lineSeparator().length(); //Se obtiene la longitud del puntero + el separador
            long posicionActualDelPuntero = raf.getFilePointer();
            raf.seek(posicionActualDelPuntero - longitudActualDelRegistro);
            raf.writeBytes(entidad.toString());
        } catch (IOException e) {
            //TODO: Log this
            throw new DAOException("Ocurrió un error al actualizar el alumno");
        }

        // reaf.seek(puntero)
        //actualizar todo el alumno
    }

    /**
     * Realiza una baja lógica, no física, del alumno
     *
     * @param dni parámetro de clave del alumno
     * @throws DAOException
     */
    @Override
    public void delete(Long dni) throws DAOException {
        Alumno alumno = read(dni);
        if (alumno == null) {
            throw new DAOException("El alumno a eliminar no existe");
        }
        alumno.setIsActivo(false);
        update(alumno);
    }

    @Override
    public boolean exists(Long dni) throws DAOException {
        return exists(dni, true);
    }

    @Override
    public boolean exists(Long dni, Boolean activos) throws DAOException {
        Alumno alumno = read(dni);

        if (activos)
            return alumno != null && alumno.isActivo();
        return alumno != null;
        
    }

    /**
     *
     * @param activos True: solo Activos - False: solo Inactivos - otherwise
     * (null): all (Activos + Inactivos)
     * @return
     * @throws DAOException
     */
    @Override
    public List<Alumno> findAll(Boolean activos) throws DAOException {
        List<Alumno> alumnos = new ArrayList<>();

        try {
            raf.seek(0); // Se posiciona al inicio
            String linea;
            String[] campos;
            while ((linea = raf.readLine()) != null) {
                campos = linea.split(persona.Persona.DELIM);
                Alumno alumno = str2Alu(campos);
                if (activos == null || activos == alumno.isActivo()) {
                    alumnos.add(alumno);
                }
            }
        } catch (IOException | NumberFormatException | PersonaException | MiCalendarioException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al leer los alumnos ==> " + ex.getMessage());
        }

        return alumnos;
    }

    @Override
    public void close() throws DAOException {

        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al cerrar el archivo ==> " + ex.getMessage());
        }
    }

}
