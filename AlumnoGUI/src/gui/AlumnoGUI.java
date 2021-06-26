/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAO;
import dao.DAOException;
import dao.DAOFactory;
import dao.DAOFactoryException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import persona.Alumno;
import persona.PersonaException;

/**
 *
 * @author gguzm
 */
public class AlumnoGUI extends javax.swing.JFrame {

    private AlumnoModel aluModel;
    List<Alumno> alumnos = new ArrayList<>();
    private DAO<Alumno, Long> dao;
    
    /**
     * Creates new form AlumnoGUI
     */
    public AlumnoGUI() {
        initComponents();
        setLocationRelativeTo(null);
        
        jButtonChooser.setVisible(true);
        
        aluModel = new AlumnoModel();
        jTableAlumnos.setModel(aluModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonChooser = new javax.swing.JButton();
        jComboBoxDAOSel = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextFieldFullPath = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTableAlumnos);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");

        jButtonChooser.setText("...");
        jButtonChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooserActionPerformed(evt);
            }
        });

        jComboBoxDAOSel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TXT", "SQL" }));
        jComboBoxDAOSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDAOSelActionPerformed(evt);
            }
        });

        jCheckBox1.setText("solo Activos");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jTextFieldFullPath.setEditable(false);

        jCheckBox2.setText("solo Eliminados");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBoxDAOSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFullPath, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonChooser)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChooser)
                    .addComponent(jComboBoxDAOSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFullPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConsultar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        int selectedAlumno = jTableAlumnos.getSelectedRow();
        if (selectedAlumno == -1) {
            // TODO mosttar por pantalla (Joption...)
            System.out.println("NO se ha seleccionada nada");
        }
        else {
            Alumno alu = alumnos.get(selectedAlumno);
            System.out.println("DNI seleccionado ==> " + alu.getDni());
            
            AlumnoDialog alumnoDialog = new AlumnoDialog(this, true);
            alumnoDialog.alu2Dialog(alu);
            System.out.println("Se abrió el diálogo!!!");
            alumnoDialog.setVisible(true); // queda el dialogo abierto hasta que se haga "setVisible(false)"
            
            Alumno aluModi = alumnoDialog.getAlumno();
            
            if (aluModi!=null) {
                // TODO call DAO
                try {
                    alu.setNombre(aluModi.getNombre());
                    alu.setFechaNacimiento(aluModi.getFechaNacimiento());
/*                    
                    aluModi = new Alumno(500, "Juam", "PErez", new MiCalendario(1, 1, 200), 
                            new MiCalendario(1, 1, 200), 50, 7.55, 'M', true);
                    BeanUtils.copyProperties(alu, aluModi);
                    
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MiCalendarioException ex) {
                    Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
  */                  
                } catch (PersonaException ex) {
                    Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                aluModel.refrescarModelo();
            }
            else {
                System.out.println("Se presionó <Cerrar> el diálogo!!!");
            }
            System.out.println("Se cerró el diálogo!!!");
        }
       
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int selectedAlumno = jTableAlumnos.getSelectedRow();
        if (selectedAlumno == -1) {
            // TODO mosttar por pantalla (Joption...)
            System.out.println("NO se ha seleccionada nada");
        }
        else {
            JOptionPane.showConfirmDialog(this, "Está Seguro???", "Confirma", JOptionPane.YES_NO_OPTION);
            
            // TODO DAO Eliminar
            
            alumnos.remove(selectedAlumno);
            
            // Refresco la grilla
            aluModel.refrescarModelo();
        }

    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooserActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        int opSel = jFileChooser.showOpenDialog(this);
        if (opSel!=jFileChooser.APPROVE_OPTION) {
            return;
        }
        
        jTextFieldFullPath.setText(jFileChooser.getSelectedFile().getAbsolutePath());
        
        Map<String, String> config = new HashMap<>();
        config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_TXT);
        config.put(DAOFactory.FILE_NAME, jTextFieldFullPath.getText());
        try {
            dao = DAOFactory.getIntance().createDAO(config);
        } catch (DAOFactoryException ex) {
            Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        displayAlumnos();
    }//GEN-LAST:event_jButtonChooserActionPerformed

    private void displayAlumnos() {
        try {
            Boolean activos = null;
            if(jCheckBox1.isSelected())
                activos = true;
            if(jCheckBox2.isSelected())
                activos = false;
            alumnos = dao.findAll(activos);
            aluModel.setAlumnos(alumnos);
            
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        
        
        try {
            dao.create(null);
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jComboBoxDAOSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDAOSelActionPerformed
                if ("TXT".equals((String)jComboBoxDAOSel.getSelectedItem())) {
            // TODO mostrar fullpath + filechooser
            // TODO ocultar textfield para conn BD
            jTextFieldFullPath.setVisible(true);
            jButtonChooser.setVisible(true);
        }
        else { // SQL
            // TODO mostrar textfield para conn BD
            // TODO ocultar fullpath + filechooser
            jTextFieldFullPath.setVisible(false);
            jButtonChooser.setVisible(false);
            
            BDDialog bDDialog = new BDDialog(this, true);
            
            jComboBoxDAOSel.setFocusable(false);
            bDDialog.setVisible(true);
            
            Map<String, String> config = new HashMap<>();
            config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_SQL);
            config.put(DAOFactory.URL_DB, "jdbc:sqlserver://localhost:1433;databaseName=efc");
            config.put(DAOFactory.USUARIO_DB, bDDialog.getDto().getUser());
            config.put(DAOFactory.PASS_DB, String.valueOf(bDDialog.getDto().getPassword()));

            try {
                dao = DAOFactory.getIntance().createDAO(config);
            } catch (DAOFactoryException ex) {
                Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            displayAlumnos();
        }
    }//GEN-LAST:event_jComboBoxDAOSelActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jCheckBox2.setEnabled(!jCheckBox1.isSelected());
        displayAlumnos();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        jCheckBox1.setEnabled(!jCheckBox2.isSelected());
        displayAlumnos();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlumnoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonChooser;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBoxDAOSel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JTextField jTextFieldFullPath;
    // End of variables declaration//GEN-END:variables
}
