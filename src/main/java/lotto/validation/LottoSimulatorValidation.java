package lotto.validation;

import lotto.error.ErrorMessage;
import lotto.utils.Utils;

public class LottoSimulatorValidation {
    private static final int UNIT_OF_COST = 1000;

    public static void validateLottoCost(String input) {
        int cost = Integer.parseInt(input);
        if (cost % UNIT_OF_COST != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COST.getMessage());
        }
    }

    public static void validateCostFormat(String input) {
        if (!Utils.isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
