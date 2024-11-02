package lotto.common;

public class CommonValidator {

    public static void validateNullAndBlank(String input) {
        if (input==null || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.BLANK_OR_NULL_INPUT);
        }
    }
}
