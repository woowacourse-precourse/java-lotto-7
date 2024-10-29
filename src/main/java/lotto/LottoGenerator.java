package lotto;

public class LottoGenerator {
    private final static int LOTTO_PRICE = 1000;
    private final int quantity;

    public LottoGenerator(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        quantity = purchaseAmount / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
