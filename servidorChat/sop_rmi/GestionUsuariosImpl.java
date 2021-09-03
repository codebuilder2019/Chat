package servidorChat.sop_rmi;

import servidorChat.service.UsersDB;
import servidorChat.service.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GestionUsuariosImpl extends UnicastRemoteObject implements GestionUsuariosInt
{
    private UsersDB usersDB;
    
    public GestionUsuariosImpl() throws RemoteException, IOException, FileNotFoundException
    {
        super(); //invoca al constructor de la clase base
        usersDB = new UsersDB("users.txt", ", ");
        usersDB.connect();
    }

    @Override
    public int registarUsuario(String nombre, String role, String departamento, String nombreUsuario, String clave) throws IOException {
        return this.usersDB.addUser(nombre, role, departamento, nombreUsuario, clave);
    }

    @Override
    public boolean eliminarUsuario(int id) throws IOException {
        return this.usersDB.deleteUserById(id);
    }
    
    @Override
    public boolean ActualizarUsuario(User user) throws IOException {
        return this.usersDB.updateById(user.getId(), user.getName(), user.getRole(), user.getDepartment(), user.getUser(), user.getPassword());
    }
    
    @Override
    public ArrayList<User> listarUsuarios() throws RemoteException {
        return this.usersDB.getUsers();
    }
    
    @Override
    public User verificarCredenciales(String nombreUsuario, String clave) throws RemoteException {
        return this.usersDB.verifyCredentials(nombreUsuario, clave);
    }
    
    @Override
    public ArrayList<User> listarUsuariosEvaluadores() throws RemoteException {

        ArrayList<User> users = this.usersDB.getUsers();
        ArrayList<User> evaluatorUsers = new ArrayList<User>();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);

            if(user.getRole().equals("evaluador")) {
                evaluatorUsers.add(user);
            }
        }

        return evaluatorUsers;
    }
}
