package lotto.validate;

import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;
import lotto.model.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator{
    public static void validateAmount(Integer input){
        isBlank(input);
        isMinus(input);
    }

    public static void validateNumber(Integer input){
        isBlank(input);
        isOutOfRange(input);
    }

    public static List<Integer> toNumberList(String input){
        return Arrays.stream(input.split(","))
                .map(Validator::toNumeric)
                .collect(Collectors.toList());
    }

    public static Integer toNumeric(String input) {
        String regex = "^[0-9]*$";
        if(!Pattern.matches(regex, input)){
            throw new InputException(ExceptionMessage.INVALID_INPUT_ERROR);
        }
        return Integer.parseInt(input);
    }

    private static void isBlank(Integer input){
        if(input == null){
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
