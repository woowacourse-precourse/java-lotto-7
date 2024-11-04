package lotto;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String DIGIT_REGEX = "^-?[0-9]*$";
    private static final String INPUT_DELIM = ",";

    public static void validateMoneyIsNumber(String amount){
        if(!amount.matches(DIGIT_REGEX))
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NOT_NUMBER_EXCEPTION.getMessage());
    }

    public static void validateNumbers(String input){
        validateIsDivisble(input);
        validateCountNumber(input);
        validateIsNumber(input);
        validateNumbersRange(input);
    }

    private static void validateIsDivisble(String input){
        try {
            String[] inputs = input.split(INPUT_DELIM);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DIVISION_EXCEPTION.getMessage());
        }
    }

    private static void validateCountNumber(String input){
        if(input.split(INPUT_DELIM).length != 6)
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_EXCEPTION.getMessage());
    }

    private static void validateIsNumber(String input){
        String[] inputs = input.split(INPUT_DELIM);
        for(String s : inputs){
            if(!s.matches(DIGIT_REGEX))
                throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER_EXCEPTION.getMessage());
        }

    }

    private static void validateNumbersRange(String input){
        List<String> inputs = Arrays.asList(input.split(INPUT_DELIM));
        for(String s : inputs){
            if(Integer.parseInt(s) < 1 || Integer.parseInt(s) > 45)
                throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public static void validateBonus(String input){
        validateBonusFormat(input);
        validateBonusRange(input);
    }

    private static void validateBonusFormat(String input){
        if(input.length() != 1 || input.matches(DIGIT_REGEX)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_COUNT_EXCEPTION.getMessage());
        }
    }

    private static void validateBonusRange(String input){
        if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45)
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_EXCEPTION.getMessage());
    }
}
