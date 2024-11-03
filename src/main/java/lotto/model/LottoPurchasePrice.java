package lotto.model;

import java.util.List;

public class LottoPurchasePrice {
    int LOTTO_PRICE = 1000;
    private final int lottoPurchasePrice;

    public LottoPurchasePrice(int lottoPurchasePrice) {
        validateLottoPurchasePrice(lottoPurchasePrice);
        this.lottoPurchasePrice = lottoPurchasePrice;
    }

    public void validateLottoPurchasePrice(int lottoPurchasePrice) {
        if (lottoPurchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getLottoPurchaseCount() {
        return lottoPurchasePrice/LOTTO_PRICE;
    }
}
