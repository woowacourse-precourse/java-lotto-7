package lotto.validation;

import lotto.exception.PriceToBuyLottoException;

import static lotto.common.constant.ErrorMessage.*;

public class PriceToBuyLottoValidator {

    private static Integer priceMaxLimit = 2000000000;

    public static void validatePriceToBuyLotto(Integer priceToBuyLotto) {
        thowExceptionIfPriceIsNull(priceToBuyLotto);
        throwExceptionIfNotDivideBy1000(priceToBuyLotto);
        throwExceptionIfPriceIsOverThanMax(priceToBuyLotto);
    }

    private static void thowExceptionIfPriceIsNull(Integer priceToBuyLotto){
        if(priceToBuyLotto == null){
            throw new PriceToBuyLottoException(PRICE_MUST_NOT_BE_NULL);
        }
    }

    private static void throwExceptionIfNotDivideBy1000(Integer priceToBuyLotto) {
        if (priceToBuyLotto % 1000 != 0) {
            throw new PriceToBuyLottoException(PRICE_SHOULD_BE_DIVIDED_BY_1000);
        }
    }

    private static void throwExceptionIfPriceIsOverThanMax(Integer priceToBuyLotto) {
        if(priceToBuyLotto < 0 || priceToBuyLotto > priceMaxLimit){
            throw new PriceToBuyLottoException(PRICE_SHOULD_BE_SMALLER_THAN_LIMITS);
        }
    }
}
