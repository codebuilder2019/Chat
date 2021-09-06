package servidorChat.sop_rmi;

import cliente.sop_rmi.*;
import servidorChat.dto.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface AdministrateInt extends Remote {
    public void addAdminitrator(AdminCallbackInt administrator) throws RemoteException;
    public void deleteAdminitrator() throws RemoteException;
}