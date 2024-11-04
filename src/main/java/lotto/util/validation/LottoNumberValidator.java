package lotto.util.validation;

import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;

import java.util.List;
import lotto.constant.LottoNumberRange;

public class LottoNumberValidator extends NumberValidator {

    private static final int MIN_LOTTO_NUMBER = LottoNumberRange.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = LottoNumberRange.MAX_LOTTO_NUMBER.getValue();
    private static final int REQUIRED_LOTTO_NUMBER_COUNT = 6;

    @Override
    public void validate(String target) {
        super.validate(target);
        validateLottoNumber(target);
    }

    private void validateLottoNumber(String target) {
        int lottoNumber = Integer.parseInt(target);
        if ((lottoNumber < MIN_LOTTO_NUMBER) || (lottoNumber > MAX_LOTTO_NUMBER)) {
            throwFail(INVALID_LOTTO_NUMBER.format(lottoNumber));
        }
    }

    public void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.format(REQUIRED_LOTTO_NUMBER_COUNT));
        }
    }
}
