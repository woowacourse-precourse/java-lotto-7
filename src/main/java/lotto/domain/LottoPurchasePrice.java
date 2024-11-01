package lotto.domain;

import lotto.enums.LottoConfig;
import lotto.enums.LottoError;

public class LottoPurchasePrice {
    private final int purchasePrice;
    private final LottoConfig lottoConfig;

    private LottoPurchasePrice(int purchasePrice, LottoConfig lottoConfig) {
        this.lottoConfig = lottoConfig;
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public static LottoPurchasePrice of(int purchasePrice, LottoConfig lottoConfig) {
        return new LottoPurchasePrice(purchasePrice, lottoConfig);
    }

    private void validate(int purchasePrice) {
        validateDivisibleByLottoPrice(purchasePrice);
        validateLessThanMaxLottoPurchasePrice(purchasePrice);
        validateMoreThanMinLottoPurchasePrice(purchasePrice);
    }

    private void validateDivisibleByLottoPrice(int purchasePrice) {
        if (purchasePrice % lottoConfig.getLottoPrice() != 0) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE.getMessage());
        }
    }

    private void validateMoreThanMinLottoPurchasePrice(int purchasePrice) {
        if (purchasePrice < lottoConfig.getLottoPurchasePriceMin()) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanMaxLottoPurchasePrice(int purchasePrice) {
        if (purchasePrice >= lottoConfig.getLottoPurchasePriceMax()) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_MORE_THAN_MAX.getMessage());
        }
    }

    public int getLottoCount() {
        return purchasePrice / lottoConfig.getLottoPrice();
    }

}
