package lotto.util;

import static lotto.common.Constant.NUMERIC_REGEX;
import static lotto.common.ErrorMessage.NON_NUMERIC_INPUT;

public class Parser {
    public Parser(){

    }
    public static int stringToInt(String input){
        isNumeric(input);
        return Integer.parseInt(input);
    }

    private static void isNumeric(String input) {
        if (!input.matches(NUMERIC_REGEX)){
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.format());
        }
    }
}
