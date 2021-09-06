package cliente.sop_rmi;

import cliente.GUIAdmin;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Aliro Correa - Septiembre de 2021
 */
public class AdminCallbackImpl extends UnicastRemoteObject implements AdminCallbackInt{

    private GUIAdmin guiAdmin;
    
    public AdminCallbackImpl(GUIAdmin guiAdmin) throws RemoteException {
        super();
        this.guiAdmin = guiAdmin;
    }

    public GUIAdmin getGuiAdmin() {
        return guiAdmin;
    }

    public void setGuiAdmin(GUIAdmin guiAdmin) {
        this.guiAdmin = guiAdmin;
    }
    
    @Override
    public void notificar(int numeroMensajes) throws RemoteException{
       this.guiAdmin.addMsg(numeroMensajes);
    }
    
}
