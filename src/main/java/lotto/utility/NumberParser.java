package lotto.utility;

public class NumberParser {

    public static int parseToInteger(String rawNumber) {
        try {
            int number = Integer.parseInt(rawNumber);
            return number;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_NUMBER.getMessage());
        }
    }
}
