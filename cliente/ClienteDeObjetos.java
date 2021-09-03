package cliente;

import SGestionAnteproyectos.service.User;
import SGestionAnteproyectos.sop_rmi.GestionAnteproyectosInt;
import SGestionAnteproyectos.sop_rmi.GestionUsuariosInt;
import cliente.sop_rmi.DirectorCllbckImpl;
import cliente.Utilidades.UtilidadesRegistroC;
import SSeguimientoAnteproyectos.sop_rmi.SeguimientoAnteproyectosInt;
import java.rmi.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Aliro Correa - Agosto de 2021
 */
public class ClienteDeObjetos {
    
    public static int PUERTO_NS = 2121;
    public static int PUERTO_NS_SEGUIMIENTO = 2122;
    public static String IP_NS = "localhost";
    
    public static GestionAnteproyectosInt objRemoto;
    public static GestionUsuariosInt objRemotoUsuarios;
    public static SeguimientoAnteproyectosInt objRemotoSeguimiento;
    public static DirectorCllbckImpl objCllbck;
    public static User currentUser;

    public static void main(String[] args) {
        
        objRemoto = (GestionAnteproyectosInt) UtilidadesRegistroC.obtenerObjRemoto(IP_NS, PUERTO_NS, "ObjetoRemotoGestionAnteproyecto");
        objRemotoUsuarios = (GestionUsuariosInt) UtilidadesRegistroC.obtenerObjRemoto(IP_NS, PUERTO_NS, "ObjetoRemotoGestionUsuario");
        objRemotoSeguimiento = (SeguimientoAnteproyectosInt) UtilidadesRegistroC.obtenerObjRemoto(IP_NS, PUERTO_NS_SEGUIMIENTO, "ObjetoRemotoSeguimientoAnteproyecto");
        
        if(objRemoto != null && objRemotoUsuarios !=  null && objRemotoSeguimiento != null){
            setDefaultTheme();
            GUILogin guiLogin = new GUILogin();
            guiLogin.setVisible(true);
        }
    }
    
    public static void setDefaultTheme(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClienteDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
