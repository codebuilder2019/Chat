package servidorChat;

import servidorChat.utilidades.UtilidadesConsola;
import servidorChat.utilidades.UtilidadesRegistroS;
import java.rmi.RemoteException;
import servidorChat.sop_rmi.GestionAnteproyectosImpl;
import servidorChat.sop_rmi.GestionUsuariosImpl;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {
        int numPuertoNS = 2121;
        String direccionIpNS = "localhost";

        try
        {
            GestionAnteproyectosImpl objRemoto = new GestionAnteproyectosImpl();
            UtilidadesRegistroS.arrancarNS(direccionIpNS, numPuertoNS);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpNS, numPuertoNS, "ObjetoRemotoGestionAnteproyecto");
            System.out.println("Objeto remoto01 registrado, esperando peticiones...");

            GestionUsuariosImpl objRemoto2 = new GestionUsuariosImpl();
            UtilidadesRegistroS.arrancarNS(direccionIpNS, numPuertoNS);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto2, direccionIpNS, numPuertoNS, "ObjetoRemotoGestionUsuario");
            System.out.println("Objeto remoto01 registrado, esperando peticiones...");
        }catch (Exception e){
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto " +  e.getMessage());
        }
    }
}
