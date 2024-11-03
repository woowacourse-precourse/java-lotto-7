package lotto.util;

public class Validator {
    public void validateEmptyInput(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public void validateNonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMBER.getMessage());
        }
    }

    public void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_NUMBER.getMessage());
        }
    }

    public void validateDivisibleByThousand(String input) {
        int number = Integer.parseInt(input);
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }
}
