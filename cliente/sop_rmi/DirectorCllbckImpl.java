package cliente.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import SGestionAnteproyectos.dto.*;
import cliente.Utilidades.UtilidadesFormulario;

public class DirectorCllbckImpl extends UnicastRemoteObject implements DirectorCllbckInt {

    public DirectorCllbckImpl() throws RemoteException{
        super();
    }

    @Override
     public void informarAprobacion(int formatoTIAId) throws RemoteException{
        UtilidadesFormulario.mensajeInformacion(">> MENSAJE DESDE EL SERVIDOR ....\n \nSe informa que los 2 conceptos de los evaluadores sobre \nel anteproyecto con id " + formatoTIAId + ", han sido dados como aprobados.\n");
     }
}