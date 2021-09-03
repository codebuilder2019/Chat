package servidorChat.sop_rmi;

import servidorChat.dto.FormatoTIADTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface GestionAnteproyectosInt extends Remote{
    public void registrarCallback(RegistroDTO objRegistro) throws RemoteException;
    public boolean asignarEvaluadores(AsignadoDTO objAsignado) throws RemoteException;

    public int solicitarCodigo() throws RemoteException;
    
    public boolean registrarFormatoTIA(FormatoTIADTO objFormatoTIA) throws RemoteException;
    public boolean registrarFormatoTIB(FormatoTIBDTO objFormatoTIB) throws RemoteException;
    public boolean registrarFormatoTIC(FormatoTICDTO objFormatoTIC) throws RemoteException;
    public boolean registrarFormatoTID(FormatoTIDDTO objFormatoTID) throws RemoteException;

    public boolean actualizarFormatoTIB(FormatoTIBDTO objFormatoTIB) throws RemoteException;

    public FormatoTIADTO consultarFormatoTIA(int id) throws RemoteException;
    public ArrayList<FormatoTIBDTO> consultarFormatosTIB(int id) throws RemoteException;
    public FormatoTICDTO consultarFormatoTIC(int id) throws RemoteException;
    public FormatoTIDDTO consultarFormatoTID(int id) throws RemoteException;

    public ArrayList<FormatoTIADTO> listarFormatosTIA() throws RemoteException;
    public ArrayList<FormatoTIADTO> listarAnteproyectosAsignados(int evaluadorId) throws RemoteException;
    public ArrayList<FormatoTIADTO> listarFormatosASinEvaluador(String department) throws RemoteException;
    public ArrayList<Integer> verificarFormatosCPendientes() throws RemoteException;
}