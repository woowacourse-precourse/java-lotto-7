package lotto.viewHandler.validator.validatorImpl;

import lotto.viewHandler.exception.NotLottoNumberRange;
import lotto.viewHandler.validator.Validator;

import static lotto.domain.Lotto.LOTTO_END_NUMBER;
import static lotto.domain.Lotto.LOTTO_START_NUMBER;
import static lotto.viewHandler.exception.MyExceptionConstant.NOT_LOTTO_NUMBER_RANGE;

public class LottoNumberRangeValidator implements Validator<Void, Integer> {
    @Override
    public Void validate(Integer input) {
        if (input < LOTTO_START_NUMBER || input > LOTTO_END_NUMBER) {
            throw new NotLottoNumberRange(NOT_LOTTO_NUMBER_RANGE);
        }
        return null;
    }
}
