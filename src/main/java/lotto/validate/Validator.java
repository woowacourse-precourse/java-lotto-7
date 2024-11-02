package lotto.validate;

import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;

import java.util.regex.Pattern;

public class Validator{
    public static void validateWinning(String input){
        String[] splitNumber = input.split(",");
        for (String number : splitNumber) {
            isNotNumeric(number);
        }
    }
    public static void validateAmount(String input){
        isNotNumeric(input);
        isMinus(input);
        isBlank(input);
    }

    private static void isBlank(String input){
        if(input.isEmpty()){
            throw new InputException(ExceptionMessage.BLANK_INPUT_ERROR);
        }
    }

    private static void isNotNumeric(String input) {
        String regex = "^[0-9]*$";
        if(!Pattern.matches(regex, input)){
            throw new InputException(ExceptionMessage.INVALID_INPUT_ERROR);
        }
    }
    private static void isMinus(String input){
        int num = Integer.parseInt(input);
        if(num < 0){
            throw new InputException(ExceptionMessage.MINUS_PRICE_ERROR);
        }
    }
}
