package servidorChat.sop_rmi;

import cliente.sop_rmi.*;
import servidorChat.dto.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ServidorCallbackInt extends Remote {
    public boolean registrarCliente(UsuarioCallbackInt objReferencia, String ncikname) throws RemoteException;
    public void enviarMensaje(String mensaje, String nickname) throws RemoteException;
    public boolean desconectarCliente(String nickname) throws RemoteException;
    public String[] obtenerClientes() throws RemoteException;
}