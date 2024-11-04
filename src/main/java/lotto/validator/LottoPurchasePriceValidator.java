package lotto.validator;

import lotto.exception.LottoException;
import lotto.model.lotto.LottoConstants;

public class LottoPurchasePriceValidator {

    public static void validateLottoPurchasePrice(int lottoPurchasePrice){
        if (lottoPurchasePrice < LottoConstants.PRICE){
            throw new IllegalArgumentException(LottoException.UNDER_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (lottoPurchasePrice > LottoConstants.MAX_PURCHASE_AMOUNT){
            throw new IllegalArgumentException(LottoException.EXCEED_MAXIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (lottoPurchasePrice % LottoConstants.PRICE != 0){
            throw new IllegalArgumentException(LottoException.INVALID_PURCHASE_PRICE.getMessage());
        }
    }
}
