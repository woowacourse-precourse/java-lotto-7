package lotto.service;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1000;

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
