package cliente;

import cliente.utilidades.UtilidadesRegistroC;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import servidorChat.sop_rmi.AdministrateImpl;
import servidorChat.sop_rmi.AdministrateInt;
import servidorChat.sop_rmi.ServidorCallbackInt;

/**
 * @author Aliro Correa - Agosto de 2021
 */
public class ClienteDeObjetos {
    
    public static int PUERTO_NS = 2121;
    public static String IP_NS = "localhost"; 

    public static ServidorCallbackInt objRemoto;
    public static AdministrateInt objRemotoAdmin;

    public static void main(String[] args) {
        
        objRemoto = (ServidorCallbackInt) UtilidadesRegistroC.obtenerObjRemoto(IP_NS, PUERTO_NS, "ObjetoRemotoServidorChat");
        
        if(objRemoto != null){
            setDefaultTheme();
            GUILogin guiLogin = new GUILogin();
            guiLogin.setVisible(true);
        }
    }
    
    public static boolean obtenerObjAdmin(){
        objRemotoAdmin = (AdministrateInt) UtilidadesRegistroC.obtenerObjRemoto(IP_NS, PUERTO_NS, "ObjetoRemotoAdministracion");
        return objRemotoAdmin != null;
    }
    
    public static void setDefaultTheme(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClienteDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
