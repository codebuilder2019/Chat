package cliente;

import cliente.sop_rmi.UsuarioCallbackImpl;
import java.io.Serializable;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 * @author Aliro Correa - Semptiembre de 2021
 */
public class GUILogin extends javax.swing.JFrame  implements Serializable {

    public GUILogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesion - Chat Grupal RMI");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Bienvenido al Chat Grupal");

        jLabel2.setText("Ingresa un nickname");

        jButtonIniciar.setText("Iniciar");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldUsuario)
                        .addComponent(jButtonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        if(this.jTextFieldUsuario.getText().length() > 1){
            this.iniciarSesion();
        }else{
            this.mensajeAdvertencia("el nickname debe contener minimo 2 caracteres");
        }
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    public void iniciarSesion(){
        String nickname = this.jTextFieldUsuario.getText();
        if(nickname.equals("admin"))
            this.iniciarAdmin();
        else
            this.iniciarCliente(nickname);
    }
    
    private void iniciarCliente(String nickname){
        GUICliente guiCliente = new GUICliente();
        try {
            UsuarioCallbackImpl objReferencia = new UsuarioCallbackImpl(guiCliente);
            boolean autorizado = cliente.ClienteDeObjetos.objRemoto.registrarCliente(objReferencia, nickname);
            if(autorizado){
                guiCliente.setInformacionUsuario(nickname);
                guiCliente.setConectados();
                guiCliente.setConfigDesconexion();
                guiCliente.setVisible(true);
                this.dispose();
            }else{
                this.mensajeAdvertencia("Este nickname ya esta en uso");
            }
        } catch (RemoteException ex) {
           this.mensajeError("Excepcion iniciarSesion() \n" + ex);
        }
    }
    
    private void iniciarAdmin(){
        GUIAdmin guiAdmin = new GUIAdmin();
        guiAdmin.setVisible(true);
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
