/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import dao.DAO;
import dao.DAOException;
import dao.DAOFactory;
import dao.DAOFactoryException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
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
public class TestDAOTXT {

    private static final String NOMBRE_ARCHIVO = "alumno.txt";
    private static DAO<Alumno, Long> dao = null;

    public static void main(String[] args) {

        try {
            setUp();
            CrearAlumnoCorrectamente();
            CrearMismoAlumnoNuevamenteGeneraError();

        } catch (DAOException | PersonaException | MiCalendarioException | DAOFactoryException ex) {
            Logger.getLogger(TestDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            tearDown();
        }
    }

    private static void CrearAlumnoCorrectamente() throws DAOException, MiCalendarioException, PersonaException {
        System.out.println(":: Ejecutando test: CrearAlumnoCorrectamente() ::");
        MiCalendario fechaNac = new MiCalendario(23, 8, 1992);
        MiCalendario fechaIng = new MiCalendario(1, 3, 1993);
        Alumno alu = new Alumno(24004612, "nombre2", "apellido2", fechaNac, fechaIng, 55, 7.33, 'M', true);        
        dao.create(alu);
        Alumno aluRead = dao.read(alu.getDni());
        if (aluRead != null) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    private static void CrearMismoAlumnoNuevamenteGeneraError() throws DAOException, MiCalendarioException, PersonaException {
        System.out.println(":: Ejecutando test: CrearMismoAlumnoNuevamenteGeneraError() ::");
        try {
            MiCalendario fechaNac = new MiCalendario(23, 8, 1992);
            MiCalendario fechaIng = new MiCalendario(1, 3, 1993);
            Alumno alu = new Alumno(24004612, "nombre2", "apellido2", fechaNac, fechaIng, 55, 7.33, 'M', true);
            
            dao.create(alu);
            System.out.println("TEST FAILED");
        } catch (DAOException ex) {
            System.out.println("TEST PASSED");
        } catch (Exception ex) {
            System.out.println("TEST FAILED");
        }
    }

    /**
     * Sets up environment for testing
     *
     * @throws DAOFactoryException
     */
    private static void setUp() throws DAOFactoryException {
        Map<String, String> config = new HashMap<>();
        config.put(DAOFactory.TIPO_DAO, "TXT");
        config.put("FILE_NAME", NOMBRE_ARCHIVO);

        dao = DAOFactory.getIntance().createDAO(config);
    }

    /**
     * Tears down environment for testing
     */
    private static void tearDown() {
        if (dao != null) {
            try {
                dao.close();
                new RandomAccessFile(NOMBRE_ARCHIVO, "rw").setLength((long) 0);
            } catch (DAOException | IOException ex) {
                Logger.getLogger(TestDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
