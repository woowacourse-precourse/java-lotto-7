package lotto.validator;

import lotto.exception.LottoException;
import lotto.model.lotto.LottoConstant;

public class LottoPurchasePriceValidator {

    public static void validateLottoPurchasePrice(int lottoPurchasePrice){
        if (lottoPurchasePrice < LottoConstant.PRICE){
            throw new IllegalArgumentException(LottoException.UNDER_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (lottoPurchasePrice > LottoConstant.MAX_PURCHASE_AMOUNT){
            throw new IllegalArgumentException(LottoException.EXCEED_MAXIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (lottoPurchasePrice % LottoConstant.PRICE != 0){
            throw new IllegalArgumentException(LottoException.INVALID_PURCHASE_PRICE.getMessage());
        }
    }
}
