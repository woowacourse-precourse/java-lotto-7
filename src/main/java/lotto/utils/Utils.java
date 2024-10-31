package lotto.utils;

import lotto.validation.Validation;

public class Utils {

    public static int stringToInteger(String input){
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }

    public static void print(String message){
        System.out.println(message);
    }

}
