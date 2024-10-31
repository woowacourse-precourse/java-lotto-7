package lotto;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    public int calculatePurchaseCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
