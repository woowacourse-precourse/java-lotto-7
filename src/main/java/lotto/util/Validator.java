package lotto.util;

public class Validator {

    public static void validateUserMoney(String userInput) {
        if(!isNumeric(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.getMessage());
        }
        if(!isPositive(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_OR_ZERO_AMOUNT_ERROR.getMessage());
        }
        if(!isDivisibleByThousand(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT_ERROR.getMessage());
        }
    }

    private static boolean isNumeric(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositive(String userInput) {
        int amount = Integer.parseInt(userInput);
        return amount > 0;
    }

    private static boolean isDivisibleByThousand(String userInput) {
        int amount = Integer.parseInt(userInput);
        return amount % 1000 == 0;
    }
}
