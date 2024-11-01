package lotto.domain;

public class Divider {
    private static final int LOTTO_PRICE = 1000;

    public static int divideInputByLottoPrice(int parsedPurchaseAmount) {
        return parsedPurchaseAmount / LOTTO_PRICE;

    }
}
