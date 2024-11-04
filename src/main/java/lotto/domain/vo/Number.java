package lotto.domain.vo;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public record Number(
        int lottoNumber
) {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static Number newInstance(int lottoNumber) {
        validateLottoNumberWithinRange(lottoNumber);
        return new Number(lottoNumber);
    }

    private static void validateLottoNumberWithinRange(int lottoNumber) {
        if (isOutOfRange(lottoNumber)) {
            throw LottoException.from(ErrorMessage.INVALID_NUMBER_RANGE_ERROR);
        }
    }

    private static boolean isOutOfRange(int lottoNumber) {
        return lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER;
    }
}
