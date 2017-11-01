package com.vladyslavboiko.xogametwo;

import java.io.Serializable;

/**
 * Created by Tom on 13.09.2017.
 */

public class UserAccount implements Serializable{
    private String eMail;
    private String nickName;

    public UserAccount(String eMail, String nickName) {
        this.eMail = eMail;
        this.nickName = nickName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
