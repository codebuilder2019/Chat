package servidorChat;

import servidorChat.sop_rmi.ServidorCallbackImpl;
import servidorChat.utilidades.UtilidadesConsola;
import servidorChat.utilidades.UtilidadesRegistroS;
import java.rmi.RemoteException;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException {
        int numPuertoNS = 2121;
        String direccionIpNS = "localhost";

        try {
            ServidorCallbackImpl objRemoto = new ServidorCallbackImpl();
            UtilidadesRegistroS.arrancarNS(direccionIpNS, numPuertoNS);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpNS, numPuertoNS, "ObjetoRemotoServidorChat");
            System.out.println("Objeto remoto01 registrado, esperando peticiones...");
        }catch (Exception e){
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto " +  e.getMessage());
        }
    }
}
