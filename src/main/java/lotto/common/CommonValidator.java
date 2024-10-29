package lotto.common;

public class CommonValidator {

    public static int validateInteger(String input) {
        if (!RegexPattern.INTEGER_INPUT.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT);
        }
        return Integer.parseInt(input);
    }
}
