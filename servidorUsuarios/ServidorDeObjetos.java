package servidorUsuarios;

import servidorUsuarios.utilidades.UtilidadesConsola;
import servidorUsuarios.utilidades.UtilidadesRegistroS;
import servidorUsuarios.sop_rmi.GestionUsuariosImpl;
import java.rmi.RemoteException;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {
        int numPuertoNS = 2121;
        String direccionIpNS = "localhost";

        try {
            GestionUsuariosImpl objRemoto = new GestionUsuariosImpl();
            UtilidadesRegistroS.arrancarNS(direccionIpNS, numPuertoNS);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpNS, numPuertoNS, "ObjetoRemotoGestionUsuarios");
            System.out.println("Objeto remoto01 registrado, esperando peticiones...");
        } catch (Exception e){
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto " +  e.getMessage());
        }
    }
}
