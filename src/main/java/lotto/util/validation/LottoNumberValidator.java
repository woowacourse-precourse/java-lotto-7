package lotto.util.validation;

import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER;

import lotto.model.Lotto;
import lotto.model.LottoNumberRange;

public class LottoNumberValidator extends NumberValidator {

    private static final int MIN_LOTTO_NUMBER = LottoNumberRange.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = LottoNumberRange.MAX_LOTTO_NUMBER.getValue();

    @Override
    public void validate(String target) {
        super.validate(target);
        validateLottoNumber(target);
    }

    private void validateLottoNumber(String target) {
        final int lottoNumber = Integer.parseInt(target);
        if ((lottoNumber < MIN_LOTTO_NUMBER) || (lottoNumber > MAX_LOTTO_NUMBER)) {
            throwFail(INVALID_LOTTO_NUMBER.format(lottoNumber));
        }
    }
}