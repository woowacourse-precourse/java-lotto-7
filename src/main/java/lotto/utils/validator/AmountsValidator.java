package lotto.utils.validator;

import static lotto.constants.ErrorMessage.*;

public class AmountsValidator {

    public static void validateLottoAmount(String amounts) {
        checkEmptyAmounts(amounts);
        checkNonNumeric(amounts);
    }

    private static void checkEmptyAmounts(String amounts) {
        if (amounts.isBlank()) {
            throw new IllegalArgumentException(EMPTY_AMOUNT.getMessage());
        }
    }

    private static void checkNonNumeric(String amounts) {
        try {
            Integer.parseInt(amounts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC.getMessage());
        }
    }
}
