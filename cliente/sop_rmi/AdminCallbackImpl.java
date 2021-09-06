package cliente.sop_rmi;

import cliente.GUIAdmin;

/**
 * @author Aliro Correa - Septiembre de 2021
 */
public class AdminCallbackImpl implements AdminCallbackInt{

    private GUIAdmin guiAdmin;
    
    public AdminCallbackImpl(GUIAdmin guiAdmin) {
        super();
        this.guiAdmin = guiAdmin;
    }

    public GUIAdmin getGuiAdmin() {
        return guiAdmin;
    }

    public void setGuiAdmin(GUIAdmin guiAdmin) {
        this.guiAdmin = guiAdmin;
    }
    
    @Override
    public void notificar(int numeroMensajes) {
       this.guiAdmin.addMsg(numeroMensajes);
    }
    
}
