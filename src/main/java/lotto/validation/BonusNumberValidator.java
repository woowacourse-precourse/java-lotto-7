package lotto.validation;

import lotto.exception.BonusNumberException;

import static lotto.common.constant.ErrorMessage.*;
import static lotto.common.constant.LottoInfo.DEFAULT_LOTTO;

public class BonusNumberValidator {

    private BonusNumberValidator(){
    }

    public static void validateBonusNumber(Integer bonusNumber) {
        throwExceptionIfNumberIsNull(bonusNumber);
        throwExceptionIfNumberIsNotValid(bonusNumber);
    }

    private static void throwExceptionIfNumberIsNull(Integer bonusNumber) {
        if (bonusNumber == null) {
            throw new BonusNumberException(BONUS_NUMBER_MUST_NOT_BE_NULL);
        }
    }

    private static void throwExceptionIfNumberIsNotValid(Integer bonusNumber) {
        if(bonusNumber < DEFAULT_LOTTO.getLowBoundOfLottoNumber() || bonusNumber > DEFAULT_LOTTO.getHighBoundOfLottoNumber()){
            throw new BonusNumberException(THERE_IS_INVALID_NUMBER_IN_BONUS_NUMBER);
        }
    }
}
