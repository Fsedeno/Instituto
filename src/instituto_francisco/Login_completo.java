/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto_francisco;

import java.awt.Container;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.EventObject;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dani
 */
public class Login_completo extends JDialog {

    private Connection conexion;
    JDialog ventana;

    public Login_completo(Frame owner, boolean modal) {
        super(owner, true);

        initComponents();
        //Añadir propiedades a los elementos gráficos
        usuario.setName("usuario");
        usuario.putClientProperty("etiqueta", jLUsuario); //para hacer la etiqueta informativa genérica, pero cómo funciona?
        usuario.putClientProperty("RegExp", "[A-Za-z0-9]{2,}");
        usuario.putClientProperty("MsgRegExp", "Escribe mínimo 2 carácteres");
        //jLUsuario.setVisible(false);

        contraseña.setName("contraseña");
        contraseña.putClientProperty("etiqueta", jLContraseña);
        contraseña.putClientProperty("RegExp", "(?=.*[a-z])(?=.*\\\\d)(?!.*[A-Z])\\\\w{5,}$");
        contraseña.putClientProperty("MsgRegExp", "Empieza Mays, min 5 cars, contiene minus y numeros");
        //jLContraseña.setVisible(false);

        nombreBD.setName("nombreBD");
        nombreBD.putClientProperty("etiqueta", jLNombreBD);
        nombreBD.putClientProperty("RegExp", "[A-Za-z0-9]{3,}");
        nombreBD.putClientProperty("MsgRegExp", "Letras y/o numeros min 3 car");
        //jLNombreBD.setVisible(false);

        servidor.setName("servidor");
        servidor.putClientProperty("etiqueta", jLServidor);
        servidor.putClientProperty("RegExp", "[A-Za-z0-9]{3,}");//expresión regular para una ip
        servidor.putClientProperty("MsgRegExp", "Letras y/o numeros min 3 car");
        //jLServidor.setVisible(false);

        puerto.putClientProperty("etiqueta", jLPuerto);
        puerto.putClientProperty("RegExp", "[0-9]{4,}");//expresión regular para una ip
        puerto.putClientProperty("MsgRegExp", "Número de 4 dígitos de puerto");
        //jLPuerto.setVisible(false);

        tipoBD.setName("Tipo de BD");
        tipoBD.putClientProperty("etiqueta", jLTipoBD);
        //jLTipoBD.setVisible(false);

        ventana = this;
        this.setResizable(false);

        botonConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ejecuto el actionPerformed manual..");
            }
        });
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tipoBD = new javax.swing.JComboBox<>();
        lTipoBD = new javax.swing.JLabel();
        lNombreBD = new javax.swing.JLabel();
        lServidorBD = new javax.swing.JLabel();
        lContraseña = new javax.swing.JLabel();
        lUsuario = new javax.swing.JLabel();
        lPuerto = new javax.swing.JLabel();
        botonConectar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        servidor = new javax.swing.JTextField();
        puerto = new javax.swing.JTextField();
        nombreBD = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLUsuario = new javax.swing.JLabel();
        jLNombreBD = new javax.swing.JLabel();
        jLContraseña = new javax.swing.JLabel();
        jLTipoBD = new javax.swing.JLabel();
        jLServidor = new javax.swing.JLabel();
        jLPuerto = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Conexión a BD");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(700, 325));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tipoBD.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        tipoBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona BD", "MySQL", "Oracle" }));
        tipoBD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tipoBD.setName("tipo de base de datos"); // NOI18N
        tipoBD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoBDItemStateChanged(evt);
            }
        });
        tipoBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBDActionPerformed(evt);
            }
        });

        lTipoBD.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        lTipoBD.setText("Tipo de BD:");

        lNombreBD.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        lNombreBD.setText("Nombre de la BD:");

        lServidorBD.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        lServidorBD.setText("Servidor de la BD:");

        lContraseña.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        lContraseña.setText("Contraseña:");

        lUsuario.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        lUsuario.setText("Usuario:");

        lPuerto.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        lPuerto.setText("Puerto:");

        botonConectar.setBackground(new java.awt.Color(255, 255, 255));
        botonConectar.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        botonConectar.setForeground(new java.awt.Color(0, 153, 102));
        botonConectar.setText("<<Conectar>>");
        botonConectar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonConectar.setEnabled(false);
        botonConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonConectarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonConectarMouseExited(evt);
            }
        });
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        botonCancelar.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(204, 0, 51));
        botonCancelar.setText("<<Cancelar>>");
        botonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCancelarMouseExited(evt);
            }
        });
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("CONEXIÓN A LA BASE DE DATOS");

        usuario.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        usuario.setName("El usuario"); // NOI18N
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioKeyReleased(evt);
            }
        });

        servidor.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        servidor.setName("El servidor"); // NOI18N
        servidor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                servidorFocusLost(evt);
            }
        });

        puerto.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        puerto.setName("El puerto"); // NOI18N
        puerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                puertoKeyReleased(evt);
            }
        });

        nombreBD.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        nombreBD.setName("El nombre base de datos"); // NOI18N
        nombreBD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreBDFocusLost(evt);
            }
        });
        nombreBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreBDKeyReleased(evt);
            }
        });

        contraseña.setName("La contraseña"); // NOI18N
        contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contraseñaKeyReleased(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jRadioButton1.setText("prog");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jRadioButton2.setText("datos");
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });

        jLUsuario.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLUsuario.setForeground(new java.awt.Color(255, 0, 51));
        jLUsuario.setText("*Campo obligatorio");

        jLNombreBD.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLNombreBD.setForeground(new java.awt.Color(255, 0, 51));
        jLNombreBD.setText("*Campo obligatorio");

        jLContraseña.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLContraseña.setForeground(new java.awt.Color(255, 0, 0));
        jLContraseña.setText("*Campo obligatorio");

        jLTipoBD.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLTipoBD.setForeground(new java.awt.Color(255, 0, 0));
        jLTipoBD.setText("Seleccione un tipo de BD");

        jLServidor.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLServidor.setForeground(new java.awt.Color(255, 0, 0));
        jLServidor.setText("*Campo obligatorio");

        jLPuerto.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLPuerto.setForeground(new java.awt.Color(255, 0, 0));
        jLPuerto.setText("*Campo obligatorio");
        jLPuerto.setToolTipText("");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jRadioButton3.setText("instituto");
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton3ItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        jLabel1.setText("Usuarios:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPuerto)
                            .addComponent(lTipoBD)
                            .addComponent(lUsuario)
                            .addComponent(lNombreBD)
                            .addComponent(lServidorBD)
                            .addComponent(lContraseña))
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonConectar)
                        .addGap(40, 40, 40)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nombreBD, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLNombreBD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tipoBD, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTipoBD, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jRadioButton2)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(165, 165, 165))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lContraseña)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNombreBD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNombreBD)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTipoBD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLTipoBD)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lServidorBD)
                            .addComponent(servidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLServidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPuerto)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addGap(8, 8, 8)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLPuerto)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonConectar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel7.getAccessibleContext().setAccessibleDescription("Ventana de acceso a la base de datos que desee");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tipoBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBDActionPerformed
        /*if (evt.getActionCommand().equalsIgnoreCase("mysql")) {
            puerto.setText("3306");
        } 
         else {
            puerto.setText("1521");
        }*/
    }//GEN-LAST:event_tipoBDActionPerformed


    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void tipoBDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoBDItemStateChanged

        JComboBox lista = (JComboBox) evt.getSource();
        JLabel etiqueta = (JLabel) lista.getClientProperty("etiqueta");

        if (lista.getSelectedIndex() == 0) {
            etiqueta.setVisible(true);
            puerto.setText("");
            jLPuerto.setVisible(true);
        } else {
            etiqueta.setVisible(false);
            if (evt.getItem().equals("MySQL")) {
                puerto.setText("3306");
            } else {
                puerto.setText("1521");
            }
        }


    }//GEN-LAST:event_tipoBDItemStateChanged

    private void botonCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseEntered
        botonCancelar.setBackground(java.awt.Color.LIGHT_GRAY);
    }//GEN-LAST:event_botonCancelarMouseEntered

    private void botonConectarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonConectarMouseEntered
        botonConectar.setBackground(java.awt.Color.LIGHT_GRAY);
    }//GEN-LAST:event_botonConectarMouseEntered

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        usuario.setText("prog");
        contraseña.setText("prog");
        nombreBD.setText("prog");
        puerto.setText("3306");
        tipoBD.setSelectedItem("MySQL");//cada item del combo se considera un objeto, por eso ponemos el String MySQL
        servidor.setText("localhost");
        botonConectar.setEnabled(true);
        for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
            JComponent componente = (JComponent) this.getContentPane().getComponent(i);
            if (componente instanceof JTextField) {
                JLabel etiqueta = (JLabel) ((JTextField)componente).getClientProperty("etiqueta");
                etiqueta.setVisible(false);
            }

        }
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
        usuario.setText("datos");
        contraseña.setText("datos");
        nombreBD.setText("datos");
        puerto.setText("1521");
        tipoBD.setSelectedIndex(2);//selecciona el item en esa posicion del combo, en este caso Oracle que es la 2
        servidor.setText("localhost");
        botonConectar.setEnabled(true);
        for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
            JComponent componente = (JComponent) this.getContentPane().getComponent(i);
            if (componente instanceof JTextField) {
                JLabel etiqueta = (JLabel) ((JTextField)componente).getClientProperty("etiqueta");
                etiqueta.setVisible(false);
            }

        }
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void botonCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCancelarMouseExited
        botonCancelar.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_botonCancelarMouseExited

    private void botonConectarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonConectarMouseExited
        botonConectar.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_botonConectarMouseExited

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        String password = new String(contraseña.getPassword());//el new String a partir de la char[] me desencripta la array y obtengo el texto que almaceno en password.

        if (compruebaDatos(this.getContentPane())) {
            /*JOptionPane.showMessageDialog(this, "Conectando a: " + usuario.getText() + "/"
                    + password + " a la BD de " + servidor.getText(), "Acceso a BD", JOptionPane.INFORMATION_MESSAGE);*/
            conexion = conectaBD((String) tipoBD.getSelectedItem(), servidor.getText(), puerto.getText(), nombreBD.getText(), usuario.getText(), password);

            if (conexion != null) {
                ventana.setVisible(false);

            } else {
                int opc = JOptionPane.showConfirmDialog(null, "Error de conexión, ¿Desea reintentar?", "Login", JOptionPane.YES_NO_CANCEL_OPTION);

                if (opc == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(this, "Saliendo de la aplicación", "Login", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }
    }//GEN-LAST:event_botonConectarActionPerformed

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
        compruebajT(evt);
    }//GEN-LAST:event_usuarioKeyReleased

    private void contraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaKeyReleased
        compruebajT(evt);
    }//GEN-LAST:event_contraseñaKeyReleased

    private void nombreBDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreBDFocusLost
        compruebajT(evt);
    }//GEN-LAST:event_nombreBDFocusLost

    private void nombreBDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreBDKeyReleased
        compruebajT(evt);
    }//GEN-LAST:event_nombreBDKeyReleased

    private void servidorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_servidorFocusLost
        compruebajT(evt);
    }//GEN-LAST:event_servidorFocusLost

    private void puertoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_puertoKeyReleased
        compruebajT(evt);
    }//GEN-LAST:event_puertoKeyReleased

    private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
        usuario.setText("instituto");
        contraseña.setText("instituto");
        nombreBD.setText("instituto");
        puerto.setText("3306");
        tipoBD.setSelectedItem("MySQL");//cada item del combo se considera un objeto, por eso ponemos el String MySQL
        servidor.setText("localhost");
        botonConectar.setEnabled(true);
        for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
            JComponent componente = (JComponent) this.getContentPane().getComponent(i);
            if (componente instanceof JTextField) {
                JLabel etiqueta = (JLabel) ((JTextField)componente).getClientProperty("etiqueta");
                etiqueta.setVisible(false);
            }

        }
    }//GEN-LAST:event_jRadioButton3ItemStateChanged

    private void compruebajT(EventObject evt) {
        JTextField campo = (JTextField) evt.getSource();
        JLabel etiqueta = (JLabel) campo.getClientProperty("etiqueta");

        if (!campo.getText().trim().isEmpty()) {//comprueba si no está vacío
            if (!campo.getText().matches((String) campo.getClientProperty("RegExp"))) {//si no hace match con la cadena
                etiqueta.setText("Formato incorrecto");
                etiqueta.setVisible(true);
                campo.setToolTipText((String) campo.getClientProperty("MsgRegExp"));

                botonConectar.setEnabled(false);
            } else {
                etiqueta.setVisible(false);
                if (compruebaTodosValidos()) {
                    botonConectar.setEnabled(true);
                }
            }

        } else {
            etiqueta.setText("*Campo obligatorio");
            etiqueta.setVisible(true);
            botonConectar.setEnabled(false);
        }
    }

    private boolean compruebaTodosValidos() {
        return jLUsuario.isVisible()
                || jLContraseña.isVisible()
                || jLServidor.isVisible()
                || jLTipoBD.isVisible()
                || jLNombreBD.isVisible()
                || jLPuerto.isVisible();
    }

    private boolean compruebaDatos(Container panel) {
        boolean datosValidos = true;

        for (int i = 0; i < panel.getComponentCount(); i++) {
            JComponent componente = (JComponent) panel.getComponent(i);

            if (componente instanceof JTextField) {
                if (((JTextField) componente).getText().trim().isEmpty()) { //isEmpty te devuelve un booleano, si está vacío true, si tiene texto: false
                    JLabel etiqueta = (JLabel) ((JTextField) componente).getClientProperty("etiqueta");
                    etiqueta.setVisible(true);
                    datosValidos = false;
                }
            } else {
                if (componente instanceof JComboBox) {
                    if (((JComboBox) componente).getSelectedIndex() == 0) {
                        JLabel etiqueta = (JLabel) ((JComboBox) componente).getClientProperty("etiqueta");
                        etiqueta.setVisible(true);
                        ((JComboBox) componente).requestFocus(); //te pone el foco o el puntero en el campo que falta
                        datosValidos = false;
                    }
                }
            }
        }
        return datosValidos;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonConectar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel jLContraseña;
    private javax.swing.JLabel jLNombreBD;
    private javax.swing.JLabel jLPuerto;
    private javax.swing.JLabel jLServidor;
    private javax.swing.JLabel jLTipoBD;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JLabel lContraseña;
    private javax.swing.JLabel lNombreBD;
    private javax.swing.JLabel lPuerto;
    private javax.swing.JLabel lServidorBD;
    private javax.swing.JLabel lTipoBD;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JTextField nombreBD;
    private javax.swing.JTextField puerto;
    private javax.swing.JTextField servidor;
    private javax.swing.JComboBox<String> tipoBD;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables

    public Connection conectaBD(String tipoBd,
            String servidor,
            String puerto,
            String nombreBd,
            String usuario,
            String contraseña) {

        String driver = "", url = "";
        String cadenaDeConexion = "";
        Connection conn = null;

        if (tipoBd.equalsIgnoreCase("Oracle")) {
            driver = "oracle.jdbc.driver.OracleDriver";
            url = "jdbc:oracle:thin:";
            cadenaDeConexion
                    = url + '@' + servidor + ":" + puerto + ":" + nombreBd;
        } else if (tipoBd.equalsIgnoreCase("mysql")) {
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql:";
            cadenaDeConexion = url + "//" + servidor + ":" + puerto + "/" + nombreBd;
        }

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(
                    cadenaDeConexion, usuario, contraseña);
            JOptionPane.showMessageDialog(this, "Se ha conectado con éxito a la BD", "Conexión exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede establecer conexión con el servidor", "Error de conexión con el servidor", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("No se puede establecer conexión con el servidor -> " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el driver -> " + ex.getMessage());
        }
        return conn;
    }

    public Connection getConn() {
        return conexion;
    }

    public void setConn(Connection conexion) {
        this.conexion = conexion;
    }
}
