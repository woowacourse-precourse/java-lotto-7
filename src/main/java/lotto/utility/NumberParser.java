package lotto.utility;

public class NumberParser {

    public static int parseToInteger(String rawNumber) {
        try {
            int number = Integer.parseInt(rawNumber);
            validateNumber(number);
            return number;
        } catch (NumberFormatException exception) {
            System.out.println(ExceptionEnum.INVALID_NUMBER.getMessage());
            throw new IllegalArgumentException(ExceptionEnum.INVALID_NUMBER.getMessage());
        }
    }

    private static void validateNumber(int number) {
        if (number <= 0) {
            System.out.println(ExceptionEnum.CANNOT_UNDER_ZERO.getMessage());
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_UNDER_ZERO.getMessage());
        }
    }
}
