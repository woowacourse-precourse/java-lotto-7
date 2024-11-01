package lotto.domain;

import lotto.enums.LottoError;

public class LottoPurchasePrice {
    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN_LOTTO_PURCHASE_PRICE = 1_000;
    private static final int MAX_LOTTO_PURCHASE_PRICE = 1_000_000_000;

    private int purchasePrice;

    private LottoPurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public static LottoPurchasePrice from(int purchasePrice) {
        return new LottoPurchasePrice(purchasePrice);
    }

    private void validate(int purchasePrice) {
        validateDivisibleByLottoPrice(purchasePrice);
        validateLessThanMaxLottoPurchasePrice(purchasePrice);
        validateMoreThanMinLottoPurchasePrice(purchasePrice);
    }

    private void validateDivisibleByLottoPrice(int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE.getMessage());
        }
    }

    private void validateMoreThanMinLottoPurchasePrice(int purchasePrice) {
        if (purchasePrice < MIN_LOTTO_PURCHASE_PRICE) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanMaxLottoPurchasePrice(int purchasePrice) {
        if (purchasePrice >= MAX_LOTTO_PURCHASE_PRICE) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_MORE_THAN_MAX.getMessage());
        }
    }

    public int getLottoCount() {
        return purchasePrice / LOTTO_PRICE;
    }

}
