package lotto.validate;

import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;
import lotto.model.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator{
    public static void validateAmount(Integer input){
        isMinus(input);
    }

    public static void validateNumber(Integer input){
        isOutOfRange(input);
    }

    public static void isNumeric(String input) {
        String regex = "^[0-9]*$";
        if(!Pattern.matches(regex, input)){
            throw new InputException(ExceptionMessage.INVALID_INPUT_ERROR);
        }
    }

    public static void isBlank(String input){
        if(Objects.equals(input, "")){
            throw new InputException(ExceptionMessage.BLANK_INPUT_ERROR);
        }
    }
    private static void isMinus(Integer input){
        if(input < 0){
            throw new InputException(ExceptionMessage.MINUS_PRICE_ERROR);
        }
    }
    private static void isOutOfRange(int value) {
        if(value < 1 || value > 45){
            throw new InputException(ExceptionMessage.NUMBER_RANGE_ERROR);
        }
    }
}
