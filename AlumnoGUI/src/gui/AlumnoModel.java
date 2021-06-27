/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import persona.Alumno;

/**
 *
 * @author Tobías
 */
public class AlumnoModel extends AbstractTableModel {

    List<Alumno> alumnos = new ArrayList<>();

    private static final String[] ENCABEZADOS = {"DNI", "Nombre", "Apellido", "Fecha Nac.", "Fecha Ingreso", "Materias aprobadas", "Promedio", "Activo"};

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
        refrescarModelo();
    }

    @Override
    public int getRowCount() {
        if (alumnos != null) {
            return alumnos.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return ENCABEZADOS.length;
    }

    @Override
    public String getColumnName(int col) {
        return ENCABEZADOS[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Alumno alu = alumnos.get(row);

        switch (col) {
            case 0: // DNI
                return alu.getDni();
            case 1: // Nombre
                return alu.getNombre();
            case 2: // Nombre
                return alu.getApellido();
            case 3: // FechaNac
                return alu.getFechaNacimiento();
            case 4:
                return alu.getFechaIngreso();
            case 5:
                return alu.getCantidadMateriasAprobadas();
            case 6:
                return alu.getPromedio();
            case 7:
                return alu.isActivo();

        }

        return null;
    }

    public void refrescarModelo() {
        fireTableDataChanged();
    }

}
