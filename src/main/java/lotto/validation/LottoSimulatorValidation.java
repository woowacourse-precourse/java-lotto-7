package lotto.validation;

import lotto.error.ErrorMessage;

public class LottoSimulatorValidation {
    private static final int UNIT_OF_COST = 1000;

    public static void validateLottoCost(String input) {
        int cost = Integer.parseInt(input);
        if (cost % UNIT_OF_COST != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COST.getMessage());
        }
    }
}
