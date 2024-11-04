package lotto;

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

}
