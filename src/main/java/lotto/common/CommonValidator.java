package lotto.common;

public class CommonValidator {

    public static int validateInteger(String input) {
        if (!RegexPattern.INTEGER_INPUT.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT);
        }
        return Integer.parseInt(input);
    }

    public static void validateNullAndBlank(String input) {
        if (input==null || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.BLANK_OR_NULL_INPUT);
        }
    }
}
