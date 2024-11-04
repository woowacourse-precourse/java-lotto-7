package lotto.validation;

import lotto.exception.LottoFactoryException;
import lotto.model.Lotto;
import lotto.model.PriceToBuyLotto;

import java.util.List;

import static lotto.common.constant.ErrorMessage.NOT_MATCH_LOTTO_COUNT_WITH_PRICE;

public class LottoFactoryValidator {
    public static void validateLottoFactory(List<Lotto> lottoes, PriceToBuyLotto priceToBuyLotto){
        throwExceptionIfNotMatchPriceAndLottoCount(lottoes, priceToBuyLotto);
    }

    private static void throwExceptionIfNotMatchPriceAndLottoCount(List<Lotto> lottoes, PriceToBuyLotto priceToBuyLotto){
        int lottoCount = Integer.divideUnsigned(priceToBuyLotto.price(), 1000);
        if(lottoCount != lottoes.size()){
            throw new LottoFactoryException(NOT_MATCH_LOTTO_COUNT_WITH_PRICE);
        }
    }
}
