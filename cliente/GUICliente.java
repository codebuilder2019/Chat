package cliente;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * @author Aliro Correa - Septiembre de 2021
 */
public class GUICliente extends javax.swing.JFrame implements Serializable{
    
    private String nickname;
    private DateTimeFormatter dateFormat;

    public GUICliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.jList1Model = new DefaultListModel();
        this.jListUsuarios.setModel(jList1Model);
        this.dateFormat = DateTimeFormatter.ofPattern("HH:mm");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelInformacionUsuario = new javax.swing.JLabel();
        jButtonCerraSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelTituloChat = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();
        jLabelBienvenido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListUsuarios = new javax.swing.JList<>();
        jLabelMensaje = new javax.swing.JLabel();
        jButtonEnviar = new javax.swing.JButton();
        jLabelConectados = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaMensaje = new javax.swing.JTextArea();
        jPanelInferior = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelCreditos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Grupal - RMI - Sistemas Distribuidos 2021-1 ");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabelInformacionUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelInformacionUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelInformacionUsuario.setText("aliroco00 en linea");

        jButtonCerraSesion.setText("Cerra Sesion");
        jButtonCerraSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerraSesionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setText("*");

        jLabelTituloChat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTituloChat.setText("Chat Grupal");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabelTituloChat))
                    .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(jLabelInformacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonCerraSesion))
                    .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTituloChat)
                .addGap(3, 3, 3)
                .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                        .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelInformacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCerraSesion))
                        .addGap(8, 8, 8))
                    .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jLabelBienvenido.setText("Bienvenido al chat ");

        jTextAreaChat.setColumns(20);
        jTextAreaChat.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextAreaChat.setLineWrap(true);
        jTextAreaChat.setRows(5);
        jTextAreaChat.setFocusable(false);
        jScrollPane1.setViewportView(jTextAreaChat);

        jListUsuarios.setFocusable(false);
        jListUsuarios.setSelectionBackground(new java.awt.Color(0, 204, 102));
        jScrollPane2.setViewportView(jListUsuarios);

        jLabelMensaje.setText("Mensaje");

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jLabelConectados.setText("Conectados");

        jTextAreaMensaje.setColumns(20);
        jTextAreaMensaje.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextAreaMensaje.setLineWrap(true);
        jTextAreaMensaje.setRows(2);
        jScrollPane4.setViewportView(jTextAreaMensaje);

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jLabelBienvenido)
                        .addGap(312, 312, 312)
                        .addComponent(jLabelConectados))
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelMensaje)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBienvenido)
                    .addComponent(jLabelConectados))
                .addGap(6, 6, 6)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabelMensaje)
                .addGap(6, 6, 6)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        jLabelCreditos.setForeground(new java.awt.Color(153, 153, 153));
        jLabelCreditos.setText(" Desarrollado por Aliro Correa <aliriocorrea@unicauca.edu.co>  y  Jaime Garcia <gjaime@unicauca.edu.co>");

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jLabelCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCreditos)
                .addContainerGap())
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerraSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerraSesionActionPerformed
        try {
            cliente.ClienteDeObjetos.objRemoto.desconectarCliente(nickname);
        } catch (RemoteException ex) {
            this.mensajeError("Excepcion desonectarCliente() " + ex.getMessage());
        } finally{
            GUILogin guiLogin = new GUILogin();
            guiLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonCerraSesionActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        this.enviarMensaje();
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    public void fijarTexto(String nombre, String msg) {
        //Este m??todo se invoca para informar al cliente de un mensaje nuevo en el chat
        jTextAreaChat.append("" + dateFormat.format(LocalDateTime.now()) + " ["+ nombre +"]: " + msg + "\n");
    }

    public void fijarContacto(String nombre) {
        //Este m??todo se invoca para informar al cliente que un nuevo ha entrado al chat
        jTextAreaChat.append("\t\t" + nombre + " en linea\n");
        System.out.println("_"+nombre + "_ == _" + this.nickname + "_");
        jList1Model.addElement(nombre);
    }

    public void eliminarContacto(String nombre) {
        jList1Model.removeElement(nombre);
    }
    
    public void setInformacionUsuario(String nickname){
        this.nickname = nickname;
        this.jLabelInformacionUsuario.setText(nickname + " en linea");
    }
    
    public void enviarMensaje() {
        try {
            String mensaje = this.jTextAreaMensaje.getText().trim();
            if (mensaje.length() > 0) {
                cliente.ClienteDeObjetos.objRemoto.enviarMensaje(mensaje, nickname);
                this.jTextAreaMensaje.setText("");
            }
        } catch (RemoteException ex){
            this.mensajeError("Excepcion enviarMensaje() " + ex.getMessage());
        }
    }
    
    public void setConfigDesconexion() {
        this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            try {
                cliente.ClienteDeObjetos.objRemoto.desconectarCliente(nickname);
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null,"Excepcion setConfigDesconexion() " + ex.getMessage());
            }
        }
        });
    }
    
    public void setConectados(){
        try {
            this.jList1Model.removeAllElements();
            String[] clientes = cliente.ClienteDeObjetos.objRemoto.obtenerClientes();
            for(String usuario : clientes){
                this.jList1Model.addElement(usuario);
            }
        } catch (RemoteException ex) {
           this.mensajeError(" Excepcion initConectados() " + ex.getMessage());
        }
        
    }
    
    private void mensajeSimple(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "MENSAJE",JOptionPane.PLAIN_MESSAGE);
    }
    
    private void mensajeInformacion(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "INFORMACION",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private  void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "ERROR",JOptionPane.ERROR_MESSAGE);
    }
    
    private void mensajeAdvertencia(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
    }
        
    
    private DefaultListModel jList1Model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerraSesion;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBienvenido;
    private javax.swing.JLabel jLabelConectados;
    private javax.swing.JLabel jLabelCreditos;
    private javax.swing.JLabel jLabelInformacionUsuario;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JLabel jLabelTituloChat;
    private javax.swing.JList<String> jListUsuarios;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextArea jTextAreaMensaje;
    // End of variables declaration//GEN-END:variables
}
