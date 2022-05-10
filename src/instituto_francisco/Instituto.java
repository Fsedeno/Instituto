/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto_francisco;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Dani
 */
public class Instituto extends MiVentanaBase {

    Connection conn;
    JTable tablaAlumnos, tablaGrupos;//para que sea un atributo de la ventana, de la clase instituto
    JEditorPane editor = new JEditorPane();

    public Instituto(String titulo, int ancho, int alto) {//recibe los parametros que tiene que enviarle a miVentana

        super(titulo, ancho, alto);
        initComponents();
        this.setVisible(true);//para que la ventana base this, sea visible
        Login_completo login = new Login_completo(this, true);//this es la ventana propietaria del jdialog de login_completo que superpone la ventana, true y false no importa, siempre envía true el super
        conn = login.getConn();
        tablaAlumnos = creaTabla(jS_alumnos, "Select * from alumnos", conn);//crea y recoge la tabla del método para usarla por el nombre
        for (int i = 0; i < tablaAlumnos.getColumnModel().getColumnCount(); i++) {//recorro las columnas para personalizar el tamaño de las celdas
            if (i != 0) {
                tablaAlumnos.getColumnModel().getColumn(i).setPreferredWidth(5);
            } else {
                tablaAlumnos.getColumnModel().getColumn(i).setPreferredWidth(130);
            }
        }
        tablaGrupos = creaTabla(jS_Grupos, "Select grupo, aula, profesor  from grupos g,profesores p where "
                + "p.id_prof = g.tutor", conn);

        JC_cursos.setModel(cargaCombo(conn, "Select grupo from grupos").getModel());
        JC_cursos.insertItemAt("Seleccione un grupo", 0);
        JC_cursos.setSelectedIndex(0);
        cargaImagenJLabel(JL_Foto, "sinfoto.png");
        tablaAlumnos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                JL_Nie.setText(String.valueOf(tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 1)));
                String nombreYAp = (String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 0);
                JL_Nombre.setText(nombreYAp.substring(nombreYAp.indexOf(",") + 2));
                JL_Apellidos.setText(nombreYAp.substring(0, nombreYAp.indexOf(",")));
                JL_Curso.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 4));
                JL_Localidad.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 3));
                JL_Cp.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 2));

                cargaImagenJLabel(JL_Foto, (String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 5));

                int id_alumno = (int) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 1);
                JTable tablaAsignaturas = creaTabla(jS_asignaturas, "Select modulos.nombre ASIGNATURAS, profesores.profesor PROFESOR from matriculas, modulos, profesores"
                        + " where alumno = " + id_alumno + " and asignatura = clave and id_prof = modulos.profesor", conn);
                tablaAsignaturas.setShowHorizontalLines(false);
            }

        });

        tablaAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KeyEvent ke = new KeyEvent(tablaAlumnos, KeyEvent.KEY_RELEASED, 1, 1, 1, 'a');//es una forma de llamar al evento Key que hicimos abajo
                tablaAlumnos.dispatchEvent(ke);//dispatch (lanza o dispara un evento) ejecuta evento
            }
        });

        tablaGrupos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
                filtra_Alumnos((String) tablaGrupos.getValueAt(tablaGrupos.getSelectedRow(), 0));
            }

        });

        tablaGrupos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                filtra_Alumnos((String) tablaGrupos.getValueAt(tablaGrupos.getSelectedRow(), 0));
            }

        });
        jComboListado.setModel(cargaCombo("src/listados").getModel());

        //Marcamos el tipo del editor
        editor.setContentType("text/plain");
        //añadimos el Jeditor al scroll
        jScrollPaneListados.setViewportView(editor);
        editor.setText("\n\n\t\tSelecciona un Listado ...");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jP_BuscarAlumnos = new javax.swing.JPanel();
        jP_ficha = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JL_Foto = new javax.swing.JLabel();
        JL_Nie = new javax.swing.JLabel();
        JL_Nombre = new javax.swing.JLabel();
        JL_Apellidos = new javax.swing.JLabel();
        JL_Curso = new javax.swing.JLabel();
        JL_Localidad = new javax.swing.JLabel();
        JL_Cp = new javax.swing.JLabel();
        jS_asignaturas = new javax.swing.JScrollPane();
        jS_alumnos = new javax.swing.JScrollPane();
        JC_cursos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jS_Grupos = new javax.swing.JScrollPane();
        jButtonListados = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jComboListado = new javax.swing.JComboBox<>();
        jScrollPaneListados = new javax.swing.JScrollPane();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jP_ficha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true), "FICHA DEL ALUMNO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NIE:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("APELLIDOS:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("LOCALIDAD:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("CP:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("CURSO:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("ASIGNATURAS MATRICULADAS:");

        JL_Foto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 1, true));

        JL_Nie.setName("datos"); // NOI18N

        JL_Nombre.setName("datos"); // NOI18N

        JL_Apellidos.setName("datos"); // NOI18N

        JL_Curso.setName("datos"); // NOI18N

        JL_Localidad.setName("datos"); // NOI18N

        JL_Cp.setName("datos"); // NOI18N

        jS_asignaturas.setBackground(new java.awt.Color(255, 255, 255));
        jS_asignaturas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        javax.swing.GroupLayout jP_fichaLayout = new javax.swing.GroupLayout(jP_ficha);
        jP_ficha.setLayout(jP_fichaLayout);
        jP_fichaLayout.setHorizontalGroup(
            jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_fichaLayout.createSequentialGroup()
                .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_fichaLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel8))
                    .addGroup(jP_fichaLayout.createSequentialGroup()
                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jP_fichaLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(jP_fichaLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4)))
                                    .addGroup(jP_fichaLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_fichaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JL_Nie, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JL_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JL_Apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JL_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jP_fichaLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JL_Localidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JL_Cp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_fichaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jS_asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_fichaLayout.setVerticalGroup(
            jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_fichaLayout.createSequentialGroup()
                .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_fichaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_fichaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JL_Nie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(JL_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JL_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .addComponent(JL_Curso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JL_Localidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jP_fichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .addComponent(JL_Cp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jS_asignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        jS_alumnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        JC_cursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un curso" }));
        JC_cursos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JC_cursosItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("GRUPOS:");

        jButtonListados.setText("Guardar Listado");
        jButtonListados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_BuscarAlumnosLayout = new javax.swing.GroupLayout(jP_BuscarAlumnos);
        jP_BuscarAlumnos.setLayout(jP_BuscarAlumnosLayout);
        jP_BuscarAlumnosLayout.setHorizontalGroup(
            jP_BuscarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_BuscarAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_BuscarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_BuscarAlumnosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JC_cursos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jButtonListados)
                        .addGap(52, 52, 52))
                    .addComponent(jS_alumnos)
                    .addComponent(jS_Grupos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jP_ficha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jP_BuscarAlumnosLayout.setVerticalGroup(
            jP_BuscarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_BuscarAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_BuscarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jP_BuscarAlumnosLayout.createSequentialGroup()
                        .addGroup(jP_BuscarAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JC_cursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonListados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jS_Grupos)
                        .addGap(18, 18, 18)
                        .addComponent(jS_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jP_ficha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar Alumnos", jP_BuscarAlumnos);

        jComboListado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Listado", " " }));
        jComboListado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboListadoItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Listados de Clase:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboListado, 0, 161, Short.MAX_VALUE))
                .addGap(168, 168, 168)
                .addComponent(jScrollPaneListados, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboListado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPaneListados, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JC_cursosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JC_cursosItemStateChanged
        filtra_Alumnos(JC_cursos.getSelectedItem().toString());
    }//GEN-LAST:event_JC_cursosItemStateChanged

    private void jButtonListadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListadosActionPerformed

        if (tablaAlumnos.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "Error No hay informaciond del grupo para guardar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String grupo = (String) tablaAlumnos.getValueAt(0, 4);
            guardaFicheroGrupo(grupo);
        }
    }//GEN-LAST:event_jButtonListadosActionPerformed

    private void jComboListadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboListadoItemStateChanged
        if (jComboListado.getSelectedItem() != "Seleccione un Listado") {
            String ruta = "src/listados/" + jComboListado.getSelectedItem().toString();
            //leemos el archivo
            try {
                String informacion = "\n";
                BufferedReader entrada = new BufferedReader(new FileReader(ruta));

                String s;
                while ((s = entrada.readLine()) != null) {
                    informacion += "\t" + s + "\n";

                }
                //añadimos el texto al Jeditorpane
                editor.setText(informacion);
                //quitamos la edicion
                editor.setEditable(false);

                entrada.close();
            } catch (FileNotFoundException ex) {
                System.out.println("No se encuentra el fichero: " + ruta);
            } catch (IOException ex) {
                System.out.println("Error de Entrada/Salida inesperado" + ex.getMessage());
            }

        } else {
            //limpiamos el jEditor
            editor.setText("\n\n\t\tSelecciona un Listado ...");
        }
    }//GEN-LAST:event_jComboListadoItemStateChanged

    public static void main(String args[]) {
        Instituto ventana = new Instituto("Aplicación Instituto", 1019, 589);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JC_cursos;
    private javax.swing.JLabel JL_Apellidos;
    private javax.swing.JLabel JL_Cp;
    private javax.swing.JLabel JL_Curso;
    private javax.swing.JLabel JL_Foto;
    private javax.swing.JLabel JL_Localidad;
    private javax.swing.JLabel JL_Nie;
    private javax.swing.JLabel JL_Nombre;
    private javax.swing.JButton jButtonListados;
    private javax.swing.JComboBox<String> jComboListado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_BuscarAlumnos;
    private javax.swing.JPanel jP_ficha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jS_Grupos;
    private javax.swing.JScrollPane jS_alumnos;
    private javax.swing.JScrollPane jS_asignaturas;
    private javax.swing.JScrollPane jScrollPaneListados;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    static JTable creaTabla(JScrollPane jScroll_Comunidades, String consulta, Connection conn) {
        DefaultTableModel dtm;
        JTable tabla = null;

        try {
            Statement stmt;
            ResultSet rset;
            ResultSetMetaData rsetMd;
            //3.- Crear un Objeto Sentencia.......
            stmt = conn.createStatement();

            //4.- Lanzar una sentencia contra la BD.......    
            rset = stmt.executeQuery(consulta);

            rsetMd = rset.getMetaData();

            //4.- Procesar el resultado de la consulta.......   
            //4.1.- Crear el array de las etiquetas de la cabecera
            Object[] etiquetas = new Object[rsetMd.getColumnCount()];

            for (int i = 0; i < rsetMd.getColumnCount(); i++) {
                etiquetas[i] = rsetMd.getColumnLabel(i + 1);
            }
            //creamos el modelo de la tabla
            dtm = new DefaultTableModel(etiquetas, 0);
            //creamos la tabla con el modelo anterior
            //3 - CREAR LA TABLA CON EL MODELO..................................
            tabla = new JTable(dtm) {
                //PARA QUE NO PUEDA EDITAR TODA LA TABLA PERO SI DARLE A LA COLUMNA DEL COMBO BOX
                @Override
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }

                @Override
                public Class getColumnClass(int c) {
                    return getValueAt(0, c).getClass();
                }
            };

            //procesamos las filas
            while (rset.next()) {
                for (int i = 0; i < rsetMd.getColumnCount(); i++) {
                    etiquetas[i] = rset.getObject(i + 1);
                }
                dtm.addRow(etiquetas);
            }
            //no permite mover el campo de la columna por otro
            tabla.getTableHeader().setReorderingAllowed(false);
            //ordenar la tabla
            TableRowSorter<TableModel> elQueOrdena = new TableRowSorter(dtm);
            tabla.setRowSorter(elQueOrdena);

            jScroll_Comunidades.setViewportView(tabla);

        } catch (SQLException ex) {
            System.out.println("Error cargando la tabla -> " + ex.getMessage());
        }
        return tabla;
    }

    static JComboBox cargaCombo(Connection conn, String select) {

        JComboBox combo = new JComboBox();
        try {
            Statement stmt;
            ResultSet rset;
            ResultSetMetaData rsetMd;

            //3.- Crear un Objeto Sentencia.......
            stmt = conn.createStatement();

            //4.- Lanzar una sentencia contra la BD.......
            rset = stmt.executeQuery(select);
            // Procesar las filasde la consulta y cargarlas en el modelo
            while (rset.next()) {
                combo.addItem(rset.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println("Error cargando el combo -> " + ex.getMessage());
        }

        return combo;
    }

    void cargaImagenJLabel(JLabel etiqueta, String ficheroImagen) {
        File archivo = new File("src/fotos/" + ficheroImagen);

        if (!ficheroImagen.isEmpty() && archivo.exists()) {//crea la foto y le da formato
            ImageIcon icono = new ImageIcon("src/fotos/" + ficheroImagen);
            icono = new ImageIcon(icono.getImage().getScaledInstance(
                    etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT));
            etiqueta.setText("");
            etiqueta.setIcon(icono);
        } else {
            etiqueta.setIcon(null);
            cargaImagenJLabel(etiqueta, "sinfoto.png");
        }
    }

    void limpiarFicha(JPanel panel) {
        String tipo;

        for (int i = 0; i < panel.getComponentCount(); i++) {
            JComponent c = (JComponent) panel.getComponent(i);
            tipo = c.getClass().getSimpleName();

            switch (tipo) {
                case "JScrollPane":
                    ((JScrollPane) c).setViewportView(null);//limpia todo lo que contenga el scrollpane
                    break;
                case "JLabel":

                    if (((JLabel) c).getName() != null) {
                        ((JLabel) c).setText("");
                    }
                    if (((JLabel) c).getIcon() != null) {
                        cargaImagenJLabel((JLabel) c, "sinfoto.png");
                    }
                    break;

            }
        }
    }

    void filtra_Alumnos(String grupo) {
        //if (JC_cursos.getSelectedIndex() != 0) {
        TableRowSorter trs = (TableRowSorter) tablaAlumnos.getRowSorter();//para ordenar el filtro obtenemos el sorter "el que ordena"
        RowFilter filtro = RowFilter.regexFilter(grupo, 4);
        trs.setRowFilter(filtro);
        limpiarFicha(jP_ficha);
        /*    
        } else {
            TableRowSorter trs = (TableRowSorter) tablaAlumnos.getRowSorter();
            trs.setRowFilter(null);//para quitar todo los rowfilter sque tiene la tabla cuando está en el campo por defecto del combo
            limpiarFicha(jP_ficha);
        }*/
    }

    JComboBox cargaCombo(String ruta) {

        JComboBox combo = new JComboBox();
        File directorio = new File(ruta);
        combo.addItem("Seleccione un Listado");
        if (directorio.listFiles() != null) {
            for (File listDir : directorio.listFiles()) {
                combo.addItem(listDir.getName());
            }
        }

        return combo;
    }

    void guardaFicheroGrupo(String grupo) {
        int k = 0;
        try {
            FileWriter fw = new FileWriter(new File("src/listados/" + grupo + ".txt"));
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Listado de la clase del Grupo: " + grupo);
            pw.println("---------------------------------------");

            for (int i = 0; i < tablaAlumnos.getRowCount(); i++) {
                pw.println("\t" + (i + 1) + ".-" + tablaAlumnos.getValueAt(i, 0));
                k++;
            }
            pw.println("---------------------------------------");
            pw.println("Total: " + k);
            pw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error guardando el Listado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}