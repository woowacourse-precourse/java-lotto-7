package lotto.domain;

import lotto.enums.LottoConfig;
import lotto.enums.LottoError;

public class LottoPurchasePrice {
    private static final int PERCENTAGE = 100;
    private final int purchasePrice;
    private final int lottoCount;

    private LottoPurchasePrice(int purchasePrice, LottoConfig lottoConfig) {
        validate(purchasePrice, lottoConfig);
        this.purchasePrice = purchasePrice;
        this.lottoCount = purchasePrice / lottoConfig.getLottoPrice();
    }

    public static LottoPurchasePrice ofPurchasePriceAndConfig(int purchasePrice, LottoConfig lottoConfig) {
        return new LottoPurchasePrice(purchasePrice, lottoConfig);
    }

    private void validate(int purchasePrice, LottoConfig lottoConfig) {
        validateDivisibleByLottoPrice(purchasePrice, lottoConfig);
        validateNumberRange(purchasePrice, lottoConfig);
    }

    private void validateNumberRange(int purchasePrice, LottoConfig lottoConfig) {
        validateLessThanMaxLottoPurchasePrice(purchasePrice, lottoConfig);
        validateMoreThanMinLottoPurchasePrice(purchasePrice, lottoConfig);
    }

    private void validateDivisibleByLottoPrice(int purchasePrice, LottoConfig lottoConfig) {
        if (purchasePrice % lottoConfig.getLottoPrice() != 0) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE.getMessage());
        }
    }

    private void validateMoreThanMinLottoPurchasePrice(int purchasePrice, LottoConfig lottoConfig) {
        if (purchasePrice < lottoConfig.getLottoPurchasePriceMin()) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanMaxLottoPurchasePrice(int purchasePrice, LottoConfig lottoConfig) {
        if (purchasePrice >= lottoConfig.getLottoPurchasePriceMax()) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_MORE_THAN_MAX.getMessage());
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public double calculateProfit(double totalPrizeMoney) {
        return (totalPrizeMoney / purchasePrice) * PERCENTAGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoPurchasePrice that = (LottoPurchasePrice) o;

        if (purchasePrice != that.purchasePrice) {
            return false;
        }
        return lottoCount == that.lottoCount;
    }

    @Override
    public int hashCode() {
        int result = purchasePrice;
        result = 31 * result + lottoCount;
        return result;
    }
}
