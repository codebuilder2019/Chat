package cliente.utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class UtilidadesRegistroC
{

    public static Remote obtenerObjRemoto(String dirIP,int puerto, String nameObjReg)
    {
        String URLRegistro;
        URLRegistro  = "rmi://" + dirIP + ":" + puerto + "/"+nameObjReg;
        try
        {
            return Naming.lookup(URLRegistro);
        }
        catch (NotBoundException | MalformedURLException | RemoteException e)
        {
            JOptionPane.showMessageDialog(null ,"Excepcion en obtencion del objeto remoto " + nameObjReg);
            return null;
        }
    }

}
