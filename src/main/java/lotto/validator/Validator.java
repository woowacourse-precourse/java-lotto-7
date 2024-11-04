package lotto.validator;

import java.util.List;
import lotto.constants.ErrorMessage;

public class Validator {

    public static void validateMoneyInput(String moneyInput) {
        validateNotBlank(moneyInput);
        validatePositiveInteger(moneyInput);
        validateIsValidMoney(moneyInput);
    }

    public static void validateNumbersInput(String numbersInput) {
        validateNotBlank(numbersInput);
        List<String> numberStrings = List.of(numbersInput.split(","));
        for (String numberString : numberStrings) {
            validatePositiveInteger(numberString);
        }
    }

    public static void validateBonusNumberInput(String numberInput) {
        validateNotBlank(numberInput);
        validatePositiveInteger(numberInput);
        validateIsValidBonusNumber(numberInput);
    }

    private static void validatePositiveInteger(String input) {
        validateIsInteger(input);
        validateIsPositive(input);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
    }

    private static void validateIsPositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
        }
    }

    private static void validateIsValidMoney(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_MONEY.getMessage());
        }
    }

    private static void validateIsValidBonusNumber(String input) {
        int number = Integer.parseInt(input);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }
}
