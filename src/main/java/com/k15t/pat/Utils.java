package com.k15t.pat;

public class Utils {


    public static boolean validateEmail (String input) {
        if (input.isEmpty()) return false;
        if (input.matches("^\\D{4,16}@\\D+.(de|com)")) return true;
        return false;
    }

    public static boolean validateName (String input) {
        if (input.isEmpty()) return false;
        if (input.matches("[a-zA-Z]+")) return true;
        return false;
    }

    public static boolean validatePhone (String input) {
        if (input.isEmpty()) return false;
        if (input.matches("\\+\\(\\d{1,3}\\)\\d{8,11}")) return true;
        return false;
    }
}
