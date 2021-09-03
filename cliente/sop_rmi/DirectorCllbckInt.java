package cliente.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import SGestionAnteproyectos.dto.*;

public interface DirectorCllbckInt extends Remote
{
    public void informarAprobacion(int formatoTIAId) throws RemoteException;
}