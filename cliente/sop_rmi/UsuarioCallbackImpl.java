package cliente.sop_rmi;

import cliente.GUICliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidorChat.dto.MessageDTO;

public class UsuarioCallbackImpl extends UnicastRemoteObject implements UsuarioCallbackInt {
    
    private GUICliente guiCliente;

    public UsuarioCallbackImpl(GUICliente guiCliente) throws RemoteException{
        super();
        this.guiCliente = guiCliente;
    }
    
    public GUICliente getGUICliente(){
        return this.guiCliente;
    }

    @Override
    public void recibirMensajes(MessageDTO message) throws RemoteException {
        guiCliente.fijarTexto(message.getNickname(), message.getMessage());
    }
    
    @Override
    public void actualizarNuevoContacto(String contacto) throws RemoteException {
        guiCliente.fijarContacto(contacto);
    }
    
    @Override
    public void eliminarContacto(String contacto) throws RemoteException {
        guiCliente.eliminarContacto(contacto);
    }
}