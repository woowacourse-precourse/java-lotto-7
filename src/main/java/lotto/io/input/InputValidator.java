package lotto.io.input;

public class InputValidator {

    private static final int ONE_THOUSAND = 1000;

    public static void validatePriceIsInThousandUnit(int price) {
        if (price % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException("Price must be in thousand units");
        }
    }

    public static void validateIsNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Input must be a number");
        }
    }

    public static void hasInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be blank");
        }
    }
}