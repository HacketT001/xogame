package com.vladyslavboiko.xogametwo;

/**
 * Created by Tom on 19.09.2017.
 */

public interface RegexContainer {
    String EMAIL_REGEX=
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    String PASSWOR_REGEX="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,}$";
    String USERNAME_REGEX="[A-Za-z0-9_]+";
}
