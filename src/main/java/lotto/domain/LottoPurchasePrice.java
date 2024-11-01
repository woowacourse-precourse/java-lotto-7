package lotto.domain;

import lotto.enums.LottoConfig;
import lotto.enums.LottoError;

public class LottoPurchasePrice {
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

    public LottoProfit calculateProfit(double totalPrizeMoney){
        return LottoProfit.ofProfitAndLottoPurchasePrice(totalPrizeMoney, purchasePrice);
    }

}
