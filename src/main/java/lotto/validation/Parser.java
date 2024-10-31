package lotto.validation;

import static lotto.ErrorMessage.NON_NUMERIC_INPUT;

public class Parser {
    public Parser(){

    }
    public static int stringToInt(String input){
        if (!input.matches("^[0-9]*$")){
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.format());
        }
        return Integer.parseInt(input);
    }
}
