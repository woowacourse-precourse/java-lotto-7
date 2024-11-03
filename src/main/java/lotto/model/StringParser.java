package lotto.model;

import static lotto.constant.ErrorMessage.*;

public class StringParser {
    static final int UNIT_AMOUNT = 1000;

    public Integer findLottoCount(String rawAmount) {
        int amount = validateInteger(rawAmount);
        int lottoCount = validatePositive(amount);
        return validateAmount(lottoCount);
    }

    private int validateInteger(String rawAmount) {
        try {
            return Integer.parseInt(rawAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_ERROR.getMessage());
        }
    }

    private int validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ERROR.getMessage());
        }
        return amount;
    }

    private int validateAmount(int amount) {
        if ((amount % UNIT_AMOUNT) == 0) {
            return amount / UNIT_AMOUNT;
        }
        throw new IllegalArgumentException(THOUSANDS_ERROR.getMessage());
    }
}
