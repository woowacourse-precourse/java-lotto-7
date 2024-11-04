package lotto.domain.vo;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public record Count(
        int lottoCount
) {
    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 100;

    public static Count newInstance(int lottoNumber) {
        validateLottoCountWithinRange(lottoNumber);
        return new Count(lottoNumber);
    }

    private static void validateLottoCountWithinRange(int lottoCount) {
        if (isLottoCountOutOfRange(lottoCount)) {
            throw LottoException.from(ErrorMessage.INVALID_LOTTO_COUNT_ERROR);
        }
    }

    private static boolean isLottoCountOutOfRange(int count) {
        return count < MIN_COUNT || count > MAX_COUNT;
    }
}
