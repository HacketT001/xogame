package com.vladyslavboiko.xogametwo;

import java.util.regex.Pattern;

/**
 * Created by Tom on 19.09.2017.
 */

public class VerifyEditTextValues {

public static boolean verifyTextByRegex(String inputText, String Regex){
    Pattern pattern = Pattern.compile(Regex);
    if(pattern.matcher(inputText).matches())
        return true;
    else return false;
    }

    public static void verifyTextByRegexPassword(String inputText) throws UserAuthException {
        if(!verifyTextByRegex(inputText,RegexContainer.PASSWOR_REGEX))
            throw new UserAuthException("Password must be 1-8 symbvols..");
    }

    public static void verifyTextByRegexEmail(String inputText) throws UserAuthException {
        if(!verifyTextByRegex(inputText,RegexContainer.EMAIL_REGEX))
            throw new UserAuthException("Wrong email");
    }

    public static void verifyTextByRegexUsername(String inputText) throws UserAuthException {
        if(!verifyTextByRegex(inputText, RegexContainer.USERNAME_REGEX))
            throw new UserAuthException("Wrong username");
    }


    public static void verifyComplex(String email, String username, String pass) throws UserAuthException {
        try{
            verifyTextByRegexPassword(pass);
            verifyTextByRegexUsername(username);
            verifyTextByRegexEmail(email);
        } catch (UserAuthException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

//verifyTextByRegexEmail(email)&&verifyTextByRegexUsername(username)&&verifyTextByRegexPassword(pass)