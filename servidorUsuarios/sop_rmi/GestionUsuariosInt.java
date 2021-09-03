package servidorUsuarios.sop_rmi;

import servidorUsuarios.service.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface GestionUsuariosInt extends Remote {
    public int registarUsuario(String nombre, String role, String nombreUsuario, String clave) throws IOException;
    public boolean eliminarUsuario(int id) throws IOException;
    public boolean ActualizarUsuario(User user) throws IOException;
    public ArrayList<User> listarUsuarios() throws RemoteException;
    public User verificarCredenciales(String nombreUsuario, String clave) throws RemoteException;
    public ArrayList<User> listarUsuariosEvaluadores() throws RemoteException;
}