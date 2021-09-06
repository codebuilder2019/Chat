package servidorChat.sop_rmi;

import cliente.sop_rmi.*;
import servidorChat.dto.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import cliente.utilidades.UtilidadesRegistroC;

public class AdministrateImpl extends UnicastRemoteObject implements AdministrateInt, Runnable
{
    private AdminCallbackInt administrator;

    public AdministrateImpl() throws RemoteException {
        super();

        Thread thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        try {
            monitor();
        } catch(Exception e) {
            System.out.println("Error en monitoreo");
        }
        
    }

    @Override
    public void addAdminitrator(AdminCallbackInt administrator) throws RemoteException {
        this.administrator = administrator;
    }

    @Override
    public void deleteAdminitrator() throws RemoteException {
        this.administrator = null;
    }

    private void monitor() throws RemoteException {
        ServidorCallbackInt objRemotoChat = (ServidorCallbackInt) UtilidadesRegistroC.obtenerObjRemoto("localhost", 2121, "ObjetoRemotoServidorChat");
        
        while (true) {
            try {
                int cycleMessageCount = objRemotoChat.obtenerCantidadMensajesEnCliclo();
                System.out.println("Monitoreando chat. Cantidad mensajes: " + cycleMessageCount);

                if(administrator != null) {
                    administrator.notificar(cycleMessageCount);
                }

                Thread.sleep(10000);
            } 
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
