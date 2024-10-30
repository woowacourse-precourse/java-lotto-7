package lotto.common.validator;

import lotto.error.CostErrorMessage;

public class CostValidator {
    public static void validate(String costCandidate) {
        NumberValidator.checkNumber(costCandidate);
        int cost = Integer.parseInt(costCandidate);
        checkMinimumPrice(cost);
        checkMaximumPrice(cost);
        checkCanDivided(cost);
    }

    private static void checkCanDivided(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(CostErrorMessage.CAN_NOT_DIVIDED
                    .getMessage());
        }
    }

    private static void checkMinimumPrice(int cost) {
        if (cost < 1000) {
            throw new IllegalArgumentException(CostErrorMessage.INSUFFICIENT_MONEY
                    .getMessage());
        }
    }

    private static void checkMaximumPrice(int cost) {
        if (cost > 1_000_000) {
            throw new IllegalArgumentException(CostErrorMessage.TOO_MANY_MONEY
                    .getMessage());
        }
    }
}
