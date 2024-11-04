package lotto;

public class InputValidator {
    private static final String DIGIT_REGEX = "^-?[0-9]*$";

    public static void validateIsNumber(String amount){
        if(!amount.matches(DIGIT_REGEX))
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NOT_NUMBER_EXCEPTION.getMessage());
    }
}
