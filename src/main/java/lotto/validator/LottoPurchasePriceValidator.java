package lotto.validator;

import java.util.regex.Pattern;
import lotto.error.LottoError;
import lotto.util.LottoParser;

public class LottoPurchasePriceValidator {

    private static final String LOTTO_PURCHASE_PRICE_PATTERN_TEXT = "^\\d+$";
    private static final Pattern LOTTO_PURCHASE_PRICE_PATTERN = Pattern.compile(LOTTO_PURCHASE_PRICE_PATTERN_TEXT);
    private final int lottoPrice;
    private final int minLottoPurchasePrice;
    private final int maxLottoPurchasePrice;

    public LottoPurchasePriceValidator(int lottoPrice, int minLottoPurchasePrice, int maxLottoPurchasePrice) {
        this.lottoPrice = lottoPrice;
        this.minLottoPurchasePrice = minLottoPurchasePrice;
        this.maxLottoPurchasePrice = maxLottoPurchasePrice;
    }

    public void validateLottoPurchasePrice(String lottoPurchasePrice) {
        validateDigit(lottoPurchasePrice);

        int lottoPurchase = LottoParser.parseInt(lottoPurchasePrice);
        validateDivisibleByLottoPrice(lottoPurchase);
        validateMoreThanMinLottoPurchasePrice(lottoPurchase);
        validateLessThanMaxLottoPurchasePrice(lottoPurchase);
    }

    private void validateDigit(String lottoPurchasePrice) {
        if (!LOTTO_PURCHASE_PRICE_PATTERN.matcher(lottoPurchasePrice).matches()) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_NOT_DIGIT.getMessage());
        }
    }

    private void validateDivisibleByLottoPrice(int lottoPurchase) {
        if (lottoPurchase % lottoPrice != 0) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE.getMessage());
        }
    }

    private void validateMoreThanMinLottoPurchasePrice(int lottoPurchase) {
        if (lottoPurchase < minLottoPurchasePrice) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanMaxLottoPurchasePrice(int lottoPurchase) {
        if (lottoPurchase >= maxLottoPurchasePrice) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_MORE_THAN_MAX.getMessage());
        }
    }

}
