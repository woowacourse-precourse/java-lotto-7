package lotto;

public class Validator {
    public static void validateAmount(String input) {
        isOnlyDigits(input);
        int amount = Integer.parseInt(input);
        isAmountInRange(amount);
        isValidAmountUnit(amount);
    }

    private static void isOnlyDigits(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c) == false)
                ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
        }
    }

    private static void isAmountInRange(int amount) {
        if (amount < 1000 || 10000 < amount)
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
    }

    private static void isValidAmountUnit(int amount) {
        if ((amount % 1000) != 0)
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
    }
}