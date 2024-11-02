package lotto.validator;

import lotto.utils.ExceptionUtils;

import static lotto.constants.LottoValue.MAX_LOTTO_NUMBER_RANGE;
import static lotto.constants.LottoValue.MIN_LOTTO_NUMBER_RANGE;

public class LottoNumberValidator {

    private static final String ERROR_LOTTO_NUMBER_RANGE = "로또 번호는 1~45 사이여야 합니다.";

    public static void validateLottoNumber(final int number){
        if(number < MIN_LOTTO_NUMBER_RANGE.getValue() || number > MAX_LOTTO_NUMBER_RANGE.getValue()) {
            ExceptionUtils.throwIllegalArgument(ERROR_LOTTO_NUMBER_RANGE);
        }
    }
}
