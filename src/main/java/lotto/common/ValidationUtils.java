package lotto.common;

import static lotto.view.OutputView.getErrorMessage;

public class ValidationUtils {

    public static void validateNumber (String rawInput, String errorMessage) {
        try {
            Long.parseLong(rawInput);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }

    public static void validateUnderMax (String rawNumber, Long maxNumber, String errorMessage) {
        if (Long.parseLong(rawNumber) > maxNumber) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }

    public static void validateAmountUnit (Integer number, Integer amountUnit, String errorMessage) {
        if (number % amountUnit != 0) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }
}
