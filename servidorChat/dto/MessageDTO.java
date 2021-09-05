package servidorChat.dto;

import java.io.Serializable;
import java.util.Date;

public class MessageDTO implements Serializable 
{
    private String nickname;
    private String message;
    private Date date;

    public MessageDTO(String nickname, String message, Date date) {
        this.nickname = nickname;
        this.message = message;
        this.date = date;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}