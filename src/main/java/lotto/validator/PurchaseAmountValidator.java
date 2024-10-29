package lotto.validator;

import lotto.dto.PurchaseAmountDto;
import lotto.exception.PurchaseAmount.*;

public class PurchaseAmountValidator {
    private static final int AMOUNT_UNIT = 1000;

    public static PurchaseAmountDto validate(final String input) {
        validateBlank(input);
        validateNumber(input);
        int convertNumber =  convert(input);
        validateNonZero(convertNumber);
        validateNonNegative(convertNumber);
        validateMultipleOfThousand(convertNumber);
        return new PurchaseAmountDto(convertNumber);
    }

    private static void validateBlank (final String input) {
        if(input.isBlank()) {
            throw new BlankAmountException();
        }
    }

    private static void validateNumber(final String input) {
        if(!Character.isDigit(input.charAt(0))) {
            throw new NotNumberException();
        }
    }

    private static void validateNonNegative(final int amount) {
        if(amount < 0) {
            throw new NegativeAmountException();
        }
    }

    private static void validateNonZero(final int amount) {
        if(amount == 0) {
            throw new ZeroAmountException();
        }
    }

    private static void validateMultipleOfThousand(final int amount) {
        if(amount % AMOUNT_UNIT != 0) {
            throw new InvalidAmountUnitException();
        }
    }

    private static int convert(String input) {
        return Integer.parseInt(input.replaceAll(" ",""));
    }
}
