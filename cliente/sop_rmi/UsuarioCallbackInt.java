package cliente.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidorChat.dto.MessageDTO;

public interface UsuarioCallbackInt extends Remote {
    public void recibirMensajes(MessageDTO message) throws RemoteException;
    public void actualizarNuevoContacto(String contacto) throws RemoteException;
    public void eliminarContacto(String contacto) throws RemoteException;
}