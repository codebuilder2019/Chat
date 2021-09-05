package cliente.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import cliente.Utilidades.UtilidadesFormulario;
import servidorChat.dto.MessageDTO;

public class UsuarioCallbackImpl extends UnicastRemoteObject implements UsuarioCallbackInt {

    public UsuarioCallbackImp() throws RemoteException{
        super();
    }

    @Override
    public void recibirMensajes(MessageDTO message) throws RemoteException {

    }
    
    @Override
    public void actualizarNuevoContacto(String contacto) throws RemoteException {

    }
    
    @Override
    public void eliminarContacto(String contacto) throws Remote Exception {

    }
}