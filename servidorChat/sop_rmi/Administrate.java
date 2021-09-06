package servidorChat.sop_rmi;

import cliente.sop_rmi.*;
import servidorChat.dto.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import cliente.utilidades.UtilidadesRegistroC;

public class Administrate extends UnicastRemoteObject
{
    public Administrate() throws RemoteException {
        monitor();
    }

    public void monitor() throws RemoteException {
        ServidorCallbackInt objRemotoChat = (ServidorCallbackInt) UtilidadesRegistroC.obtenerObjRemoto("localhost", 2121, "ObjetoRemotoServidorChat");
        
        while (true) {
            try {
                int cycleMessageCount = objRemotoChat.obtenerCantidadMensajesEnCliclo();
                System.out.println("Monitoreando chat. Cantidad mensajes: " + cycleMessageCount);
                Thread.sleep(10000);
            } 
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
