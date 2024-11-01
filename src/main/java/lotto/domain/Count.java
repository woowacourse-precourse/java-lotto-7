package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_MIN;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_TYPE;

import lotto.exception.LottoException;

public class Count {
    private final int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count from(String money) {
        int count = calculateCount(money);
        return new Count(count);
    }

    private static int calculateCount(String money) {
        CountValidator.validateType(money);
        int purchase = Integer.parseInt(money);
        CountValidator.validateUnit(purchase);
        int count = purchase / 1000;
        CountValidator.validateCount(count);
        return count;
    }

    private static class CountValidator {
        private static void validateType(String money) {
            if (!money.matches("\\d+")) {
                throw new LottoException(INVALID_PURCHASE_TYPE);
            }
        }

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
