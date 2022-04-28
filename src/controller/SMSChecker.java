package controller;

import refactor.Registration;

import java.util.Locale;

public class SMSChecker {
    private static boolean validRegistration = false;
    private boolean validUserInformation = false;
    private boolean validName = false;
    private boolean validBirthdate = false;
    private boolean validAddress = false;

    public static boolean checkRegister(String register){

        if(register.toLowerCase(Locale.ROOT).equals("register")){
            validRegistration = true;
            return true;
        }
        return false;
    }

    public static boolean checkUserInfo(String register){
        return true;
    }
}
