package lotto.model;

public class LottoPurchasePrice {
    private final int LOTTO_PRICE = 1000;
    private final int ZERO = 0;
    private final int lottoPurchasePrice;

    public LottoPurchasePrice(int lottoPurchasePrice) {
        validateLottoPurchasePrice(lottoPurchasePrice);
        this.lottoPurchasePrice = lottoPurchasePrice;
    }

    public void validateLottoPurchasePrice(int lottoPurchasePrice) {
        if (lottoPurchasePrice % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("[Error] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getPurchaseCount() {
        return lottoPurchasePrice / LOTTO_PRICE;
    }

    public int getPurchasePrice() {
        return lottoPurchasePrice;
    }
}
