package servidorChat.sop_rmi;

import cliente.sop_rmi.*;
import servidorChat.dto.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class ServidorCallbackImpl extends UnicastRemoteObject implements ServidorCallbackInt
{
    private ArrayList<ContactDTO> contacts;
    private ArrayList<MessageDTO> messages;

    public ServidorCallbackImpl() throws RemoteException {
        super();
        contacts = new ArrayList();
        messages = new ArrayList();
    }

    @Override
    public boolean registrarCliente(UsuarioCallbackInt objReferencia, String nickname) throws RemoteException {
        System.out.println("Registrando cliente");

        if(findContact(nickname)) {
            return false;
        } else {
            ContactDTO contact = new ContactDTO(nickname, objReferencia);
            this.contacts.add(contact);

            for (int i=0; i<this.contacts.size(); i++) {
                this.contacts.get(i).getObjReference().actualizarNuevoContacto(nickname);
            }
            
            return true;
        }
    }

    @Override
    public void enviarMensaje(String mensaje, String nickname) throws RemoteException {
        System.out.println("Registrando mensaje de cliente");

        if(findContact(nickname)) {
            Date date = new Date();
            MessageDTO newMessage = new MessageDTO(nickname, mensaje, date);
            this.messages.add(newMessage);

            for (int i=0; i<this.contacts.size(); i++) {
                this.contacts.get(i).getObjReference().recibirMensajes(newMessage);
            }
        }
    }

    @Override
    public boolean desconectarCliente(String nickname) throws RemoteException {
        System.out.println("Desconectando cliente");

        if(findContact(nickname)) {
            int contactIndex = this.contacts.indexOf(nickname);
            this.contacts.remove(contactIndex);
            
            for (int i=0; i<this.contacts.size(); i++) {
                this.contacts.get(i).getObjReference().eliminarContacto(nickname);
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean findContact(String nickname) {
        String aNickname;

        for (int i=0; i<this.contacts.size(); i++) {
            aNickname = this.contacts.get(i).getNickname();

            if(nickname.equals(aNickname)){
                return true;
            }
        }

        return false;
    }
}
