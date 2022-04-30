package controller;


import java.util.logging.Level;
import java.util.logging.Logger;

public class SMSChecker {
    final private static Logger logger = Logger.getLogger(SMSChecker.class.getName());

    public static boolean checkRegister(String register) {
        boolean validRegistration = false;

        if (register.equalsIgnoreCase("REGISTER")) {
            validRegistration = true;
        }

        if(validRegistration){
            logger.log(Level.INFO, register + ": Valid Keyword");
        } else {
            logger.log(Level.WARNING, register + ": Invalid Keyword");
        }

        return validRegistration;
    }

    public static boolean checkUserInfo(String userInfo) {
        boolean validUserInfo = false;
        boolean validFullName = false;
        boolean validBirthdate = false;
        boolean validAddress = false;

        String fullName;
        String birthdate;
        String address;

        if (userInfo.length() > 0) {
            if (userInfo.charAt(0) != ' ' && userInfo.charAt(userInfo.length() - 1) != ' ') {
                if (userInfo.contains(",")) {
                    String arrayUserInfo[] = userInfo.split(",");
                    if (arrayUserInfo.length == 3) {
                        fullName = arrayUserInfo[0];
                        birthdate = arrayUserInfo[1];
                        address = arrayUserInfo[2];

                        validFullName = checkFullName(fullName);
                        validBirthdate = checkBirthdate(birthdate);
                        validAddress = checkAddress(address);

                    }
                }
            }
        }

        if (validFullName && validBirthdate && validAddress) {
            validUserInfo = true;
        }

        if(validUserInfo){
            logger.log(Level.INFO, userInfo + ": Valid User Information");
        } else {
            logger.log(Level.WARNING, userInfo + ": Invalid User Information");
        }
        return validUserInfo;
    }

    public static boolean checkFullName(String fullName) {
        boolean validName = false;
        boolean isAlphabetic = true;
        boolean isNameFull = false;

        if (fullName.length() > 0) {
            if (fullName.charAt(0) != ' ' && fullName.charAt(fullName.length() - 1) != ' ') {
                for (int index = 0; index < fullName.length(); index++) {
                    if (!Character.isAlphabetic(fullName.charAt(index))) {
                        if (fullName.charAt(index) != ' ') {
                            isAlphabetic = false;
                        } else {
                            isNameFull = true;
                        }
                    }
                }
                if (isAlphabetic && isNameFull) {
                    validName = true;
                }
            }
        }

        return validName;
    }

    public static boolean checkBirthdate(String birthdate) {
        boolean validBirthdate = false;
        boolean validYear = false;
        boolean validMonth = false;
        boolean validDay = false;
        String year = null;
        String month = null;
        String day = null;

        if (birthdate.length() > 0) {
            if (birthdate.charAt(0) != ' ' && birthdate.charAt(birthdate.length() - 1) != ' ') {
                if (birthdate.contains("-")) {
                    String arrayBirthdate[] = birthdate.split("-");
                    if (arrayBirthdate.length == 3) {
                        year = arrayBirthdate[0];
                        month = arrayBirthdate[1];
                        day = arrayBirthdate[2];

                        validYear = checkYear(year);
                        validMonth = checkMonth(month);
                        validDay = checkDay(day);
                    }
                }
            }
        }

        if (validYear && validMonth && validDay) {
            validBirthdate = true;
        }

        if(validBirthdate){
            if (Integer.parseInt(month) == 2) {
                //verify if leap year
                //verify if valid leap year date
                if (checkLeapYear(year)) {
                    if (Integer.parseInt(day) > 29) {
                        validBirthdate = false;
                    }
                } else {
                    if (Integer.parseInt(day) > 28) {
                        validBirthdate = false;
                    }
                }
            } else {
                //verify if month has 30/31 days
                if (Integer.parseInt(month) == 4 || Integer.parseInt(month) == 6 || Integer.parseInt(month) == 9 || Integer.parseInt(month) == 11) {
                    if (Integer.parseInt(day) > 30) {
                        validBirthdate = false;
                    }
                }
            }
        }

        return validBirthdate;
    }

    public static boolean checkYear(String year) {
        boolean validYear = false;
        boolean isNumeric = true;

        if (year.length() == 4) {
            for (int index = 0; index < year.length(); index++) {
                if (!Character.isDigit(year.charAt(index))) {
                    isNumeric = false;
                }
            }
            if (isNumeric) {
                validYear = true;
            }
        }

        return validYear;
    }

    public static boolean checkMonth(String month) {
        boolean validMonth = false;
        boolean isNumeric = true;

        if (month.length() == 2) {
            for (int index = 0; index < month.length(); index++) {
                if (!Character.isDigit(month.charAt(index))) {
                    isNumeric = false;
                }
            }
            if (isNumeric) {
                if (Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13) {
                    validMonth = true;
                }
            }
        }

        return validMonth;
    }

    public static boolean checkDay(String day) {
        boolean validDay = false;
        boolean isNumeric = true;

        if (day.length() == 2) {
            for (int index = 0; index < day.length(); index++) {
                if (!Character.isDigit(day.charAt(index))) {
                    isNumeric = false;
                }
            }
            if (isNumeric) {
                if (Integer.parseInt(day) > 0 && Integer.parseInt(day) < 32) {
                    validDay = true;
                }
            }
        }

        return validDay;
    }

    public static boolean checkLeapYear(String year) {
        boolean isLeapYear = false;
        //verify if year is divisible by 4
        if (Integer.parseInt(year) % 4 == 0) {
            //verify if year is a century
            if (Integer.parseInt(year) % 100 == 0) {
                //verify if year is a century and divisible by 4
                if (Integer.parseInt(year) % 400 == 0)
                    isLeapYear = true;
                else
                    isLeapYear = false;
            }
            //if year is not a century
            else
                isLeapYear = true;
        }
        //if year is not divisible by 4
        else
            isLeapYear = false;

        return isLeapYear;
    }

    public static boolean checkAddress(String address) {
        boolean validAddress = false;
        boolean isAlphabetic = true;

        if (address.length() > 0) {
            if (address.charAt(0) != ' ' && address.charAt(address.length() - 1) != ' ') {
                for (int index = 0; index < address.length(); index++) {
                    if (!Character.isAlphabetic(address.charAt(index))) {
                        if (address.charAt(index) != ' ') {
                            isAlphabetic = false;
                        }
                    }
                }
                if (isAlphabetic) {
                    validAddress = true;
                }
            }
        }

        return validAddress;
    }
}
