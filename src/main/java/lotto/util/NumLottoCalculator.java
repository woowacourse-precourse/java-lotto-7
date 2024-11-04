package lotto.util;

import static lotto.constants.CommonConstants.UNIT_PURCHASE_AMOUNT;

public class NumLottoCalculator {
    public static long calculate(long purchaseAmount) {
        return purchaseAmount / UNIT_PURCHASE_AMOUNT;
    }
}
