package lotto.util;

public class NumLottoCalculator {
    private static final Long UNIT_PURCHASE_AMOUNT = 1000L;

    public static long calculate(long purchaseAmount) {
        return purchaseAmount / UNIT_PURCHASE_AMOUNT;
    }
}
