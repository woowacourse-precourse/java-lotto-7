package lotto.validator;

public final class Validator {
    public static void validateMoneyInput(String moneyInput) {
        validateNotBlank(moneyInput);
        validateIsInteger(moneyInput);
    }

    private static void validateNotBlank(String moneyInput) {
        if (moneyInput == null || moneyInput.isBlank()) {
            throw new IllegalArgumentException("Input is empty");
        }
    }

    private static void validateIsInteger(String moneyInput) {
        try {
            Integer.parseInt(moneyInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Total round must be integer number");
        }
    }
}
