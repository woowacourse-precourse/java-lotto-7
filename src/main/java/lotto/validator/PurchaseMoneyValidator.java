package lotto.validator;

import static lotto.validator.ErrorMessage.*;

public class PurchaseMoneyValidator {
    private PurchaseMoneyValidator() {
    }

    public static void validateInteger(String token) {
        try {
            Integer.parseInt(token);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + TYPE.getMessage());
        }
    }

    public static void validateDivisibleByThousand(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + DIVIDE.getMessage());
        }
    }
}
