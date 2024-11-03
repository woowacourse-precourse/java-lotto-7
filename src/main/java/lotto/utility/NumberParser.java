package lotto.utility;

public class NumberParser {

    public static int parseToInteger(String rawNumber) {
        try {
            int number = Integer.parseInt(rawNumber);
            validateNumber(number);
            return number;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_NUMBER.getMessage());
        }
    }

    private static void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_UNDER_ZERO.getMessage());
        }
    }
}
