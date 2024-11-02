package lotto.util;

import static lotto.common.ErrorMessage.NON_NUMERIC_INPUT;

public class Parser {
    public Parser(){

    }
    public static int stringToInt(String input){
        isNumeric(input);
        return Integer.parseInt(input);
    }

    private static void isNumeric(String input) {
        if (!input.matches("^[0-9]*$")){
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.format());
        }
    }
}
