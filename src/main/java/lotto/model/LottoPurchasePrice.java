package lotto.model;

import java.util.List;

public class LottoPurchasePrice {
    int LOTTO_PRICE = 1000;
    private final String lottoPurchasePrice;
    private final int lottoPurchaseCount;

    public LottoPurchasePrice(String lottoPurchasePrice) {
        this.lottoPurchasePrice = lottoPurchasePrice;
        validateLottoPurchasePrice(lottoPurchasePrice);
        this.lottoPurchaseCount = convertPriceToCount(lottoPurchasePrice);

    }

    private int convertPriceToCount(String lottoPurchasePrice) {
        return Integer.parseInt(lottoPurchasePrice)/LOTTO_PRICE;
    }

    private void validateLottoPurchasePrice(String lottoPurchasePrice) {
        if (Integer.parseInt(lottoPurchasePrice) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }
}
