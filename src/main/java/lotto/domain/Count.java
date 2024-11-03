package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_MIN;

import lotto.exception.LottoException;

public class Count {
    private final int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count from(int money) {
        int count = calculateCount(money);
        return new Count(count);
    }

    private static int calculateCount(int money) {
        CountValidator.validateUnit(money);
        int count = money / 1000;
        CountValidator.validateCount(count);
        return count;
    }

    private static class CountValidator {
        private static void validateUnit(int money) {
            if (money % 1000 != 0) {
                throw new LottoException(INVALID_PURCHASE_AMOUNT_UNIT);
            }
        }

        private static void validateCount(int count) {
            if (count < 1) {
                throw new LottoException(INVALID_PURCHASE_MIN);
            }
        }
    }

    public int getCount() {
        return count;
    }
}
