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
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.List;
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
            ActualizarAlumnoCorrectamente();            
            CrearIntegrantesDelGrupooYObtenerTodo();
            EliminarAlumnoCorrectamente();
            CrearIntegrantesDelGrupooYObtenerTodo();
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

    private static void ActualizarAlumnoCorrectamente() {
        System.out.println(":: Ejecutando test: ActualizarAlumnoCorrectamente() ::");
        try {
            Alumno alumno = dao.read((long) 24004612);

            alumno.setApellido("Rodriguez");

            dao.update(alumno);

            System.out.println("TEST PASSED");
        } catch (DAOException | PersonaException e) {
            System.out.println("TEST FAILED");
        }
    }

    private static void EliminarAlumnoCorrectamente() {
        System.out.println(":: Ejecutando test: EliminarAlumnoCorrectamente() ::");
        try {
            Alumno alumno = dao.read((long) 34230397);

            dao.delete(alumno.getDni());

            if (!dao.exists(alumno.getDni())) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }
        } catch (DAOException e) {
            System.out.println("TEST FAILED");
        }
    }
    
    private static void CrearIntegrantesDelGrupooYObtenerTodo()throws DAOException, MiCalendarioException, PersonaException
    {
        System.out.println(":: Ejecutando test: CrearIntegrantesDelGrupooYObtenerTodo() ::");
        MiCalendario fechaIng = new MiCalendario(15, 4, 2020);
        
        MiCalendario fechaNac1 = new MiCalendario(23, 8, 1992);
        Alumno alu1 = new Alumno(34230397, "Tobias", "Girado", fechaNac1, fechaIng, 55, 7.33, 'M', true);
        dao.create(alu1);
        
        MiCalendario fechaNac2 = new MiCalendario(5, 1, 1993);
        Alumno alu2 = new Alumno(37141361, "Jonathan", "Hartmann", fechaNac2, fechaIng, 50, 7.66, 'M', true);
        dao.create(alu2);
        
        MiCalendario fechaNac3 = new MiCalendario(24, 3, 1993);
        Alumno alu3 = new Alumno(37250568, "Lautaro", "Pizzagalli", fechaNac3, fechaIng, 32, 4.25, 'M', true);
        dao.create(alu3);
        
        MiCalendario fechaNac4 = new MiCalendario(20, 10, 1990);
        Alumno alu4 = new Alumno(29365310, "Alejandro", "Rey", fechaNac4, fechaIng, 32, 4.25, 'M', true);
        dao.create(alu4);
        
        MiCalendario fechaNac5 = new MiCalendario(1, 2, 1975);
        Alumno alu5 = new Alumno(17566436, "Pablo", "Segobia", fechaNac5, fechaIng, 32, 4.25, 'M', true);
        dao.create(alu5);
        
        List<Alumno> lista = dao.findAll(true);
        
        if(lista != null)
        {
            for (Alumno alu: lista)
                System.out.println(alu.toString());
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
