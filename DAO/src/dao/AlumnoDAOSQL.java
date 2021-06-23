/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.MiCalendario;
import persona.PersonaException;

/**
 *
 * @author Tobias
 */
public class AlumnoDAOSQL extends DAO<Alumno, Long> {

    private Connection conn;
    private PreparedStatement insertPS;
    private PreparedStatement selectPS;
    private PreparedStatement updatePS;
    private PreparedStatement deletePS;
    private PreparedStatement findsAllPS;

    AlumnoDAOSQL(String url, String usuario, String password) throws DAOException {

        try {
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al conectarse con la BD ==> " + ex.getMessage());
        }
        String insertSQL = "INSERT INTO alumnos\n"
                + "(DNI,\n"
                + "NOMBRE,\n"
                + "APELLIDO,\n"
                + "FECHA_NACIMIENTO,\n"
                + "FECHA_INGRESO,\n"
                + "SEXO,\n"
                + "PROMEDIO,\n"
                + "ACTIVO)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?,?);";

        try {
            insertPS = conn.prepareStatement(insertSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear sentencia para INSERT ==> " + ex.getMessage());
        }

        String selectSQL = "SELECT * FROM alumnos where DNI = ?";

        try {
            selectPS = conn.prepareStatement(selectSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear sentencia para SELECT ==> " + ex.getMessage());
        }
        //TODO: agregar materias aprobadas (idem al create)
        String updateSQL = "UPDATE alumnos\n"
                + "SET NOMBRE = ? ,\n"
                + "APELLIDO = ? ,\n"
                + "FECHA_NACIMIENTO = ? ,\n"
                + "FECHA_INGRESO = ? ,\n"
                + "SEXO = ? ,\n"
                + "PROMEDIO = ?\n"
                + "WHERE DNI = ?";

        try {
            updatePS = conn.prepareStatement(updateSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear sentencia para UPDATE ==> " + ex.getMessage());
        }

        String deleteSQL = "UPDATE alumnos\n"
                + "SET ACTIVO = 0"
                + "WHERE DNI = ?";

        try {
            deletePS = conn.prepareStatement(deleteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear sentencia para DELETE logico ==> " + ex.getMessage());
        }

        String findsAllSQL = "SELECT * FROM alumnos";

        try {
            findsAllPS = conn.prepareStatement(findsAllSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear sentencia para SELECT ALL ==> " + ex.getMessage());
        }

    }

    @Override
    public void create(Alumno alumno) throws DAOException {
        try {
            int index = 1;
            insertPS.setLong(index++, alumno.getDni());
            insertPS.setString(index++, alumno.getNombre());
            insertPS.setString(index++, alumno.getApellido());
            insertPS.setDate(index++, alumno.getFechaNacimiento().toSQLDate());
            insertPS.setDate(index++, alumno.getFechaIngreso().toSQLDate());
            insertPS.setString(index++, String.valueOf(alumno.getSexo()));
            insertPS.setDouble(index++, alumno.getPromedio());
            insertPS.setBoolean(index++, alumno.isActivo());

            insertPS.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al insertar en le BD ==>" + ex.getMessage());
        }
    }

    @Override
    public Alumno read(Long dni) throws DAOException {
        Alumno alumno = null;
        try {
            selectPS.setLong(1, dni);
            ResultSet rs = selectPS.executeQuery();
            //TODO Unificar con FindAll para no tener duplicidad de código
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setDni(dni);
                alumno.setNombre(rs.getString("NOMBRE"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setFechaNacimiento(new MiCalendario(rs.getDate("FECHA_NACIMIENTO")));
                alumno.setFechaIngreso(new MiCalendario(rs.getDate("FECHA_INGRESO")));                
                alumno.setSexo(rs.getString("SEXO").charAt(0));
                alumno.setPromedio(rs.getDouble("PROMEDIO"));
                alumno.setIsActivo(rs.getBoolean("ACTIVO"));
            }

        } catch (SQLException | PersonaException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("No se encontró un alumno para el dni" + dni + ".");
        }

        return alumno;
    }

    @Override
    public void update(Alumno alumno) throws DAOException {
        try {
            int index = 1;
            updatePS.setString(index++, alumno.getNombre());
            updatePS.setString(index++, alumno.getApellido());
            updatePS.setDate(index++, alumno.getFechaNacimiento().toSQLDate());
            updatePS.setDate(index++, alumno.getFechaIngreso().toSQLDate());            
            updatePS.setString(index++, String.valueOf(alumno.getSexo()));
            updatePS.setDouble(index++, alumno.getPromedio());
            updatePS.setLong(index++, alumno.getDni());

            updatePS.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al actualizar en la BD ==>" + ex.getMessage());
        }
    }

    @Override
    public void delete(Long dni) throws DAOException {
        try {
            int index = 1;
            deletePS.setLong(index++, dni);

            deletePS.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al borrar logicamente en le BD ==>" + ex.getMessage());
        }
    }

    @Override
    public boolean exists(Long dni) throws DAOException {
        return exists(dni, true);
    }

    @Override
    public boolean exists(Long dni, Boolean activos) throws DAOException {
        try {
            Alumno alumno = read(dni);

            if (activos)
                return alumno != null && alumno.isActivo();
            return alumno != null;
            
        } catch (DAOException ex) {
            return false;
        }
    }

    @Override
    public List<Alumno> findAll(Boolean activos) throws DAOException {
        List<Alumno> alumnos = new ArrayList<>();

        try {
            ResultSet rs = findsAllPS.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setDni(rs.getLong("DNI"));
                alumno.setNombre(rs.getString("NOMBRE"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setFechaNacimiento(new MiCalendario(rs.getDate("FECHA_NACIMIENTO")));
                alumno.setFechaIngreso(new MiCalendario(rs.getDate("FECHA_INGRESO")));                
                alumno.setSexo(rs.getString("SEXO").charAt(0));
                alumno.setPromedio(rs.getDouble("PROMEDIO"));
                alumno.setIsActivo(rs.getBoolean("ACTIVO"));

                //TODO: Filtrado en la query SQL directamente
                if (!activos || (activos && alumno.isActivo())) {
                    alumnos.add(alumno);
                }

            }
        } catch (SQLException | PersonaException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al leer los alumnos ==> " + ex.getMessage());
        }

        return alumnos;
    }

    @Override
    public void close() throws DAOException {

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al cerrar la BD ==> " + ex.getMessage());
        }
    }

}
