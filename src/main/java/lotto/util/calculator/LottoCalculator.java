package lotto.util.calculator;

public final class LottoCalculator {

    private LottoCalculator() {
    }

    private static final int LOTTO_PRICE = 1_000;

    public static long getNumberOfAbleToPurchase(final long money) {
        return money / LOTTO_PRICE;
    }

}
