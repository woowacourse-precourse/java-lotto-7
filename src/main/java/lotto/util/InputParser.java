package lotto.util;

public class InputParser {

    private InputParser() {
    }

    public static int parsePositiveNumber(String number, String errorMessage) {
        InputValidator.validateInput(number);
        try {
            int intNumber = Integer.parseInt(number);
            if (intNumber <= 0) {
                throw new IllegalArgumentException(errorMessage);
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
