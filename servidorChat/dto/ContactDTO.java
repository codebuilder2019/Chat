package servidorChat.dto;

import java.io.Serializable;
import servidorChat.dto.*;
import cliente.sop_rmi.*;

public class ContactDTO implements Serializable 
{
    private String nickname;
    private UsuarioCallbackInt objReference;

    public ContactDTO(String nickname, UsuarioCallbackInt objReference) {
        this.nickname = nickname;
        this.objReference = objReference;
    }

    public String getNickname() {
        return nickname;
    }

    public UsuarioCallbackInt getObjReference() {
        return objReference;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setObjectReference(UsuarioCallbackInt objReference) {
        this.objReference = objReference;
    }
}