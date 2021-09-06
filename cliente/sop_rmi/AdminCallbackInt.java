package cliente.sop_rmi;

import java.rmi.Remote;

/**
 * @author Aliro Correa - Septiembre de 2021
 */
public interface AdminCallbackInt extends Remote {
    public void notificar(int numeroMensajes);
}
