package lotto.utility;

public class NumberParser {

    public static int parseToInteger(String rawNumber) {
        try {
            int number = Integer.parseInt(rawNumber);
            validateNumber(number);
            return number;
        } catch (NumberFormatException exception) {
            ExceptionThrower.throwing(ExceptionEnum.INVALID_NUMBER);
        }
    }

    private static void validateNumber(int number) {
        if (number <= 0) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_UNDER_ZERO);
        }
    }
}
