package lotto.vo;

import lotto.constant.ErrorMessage;
import lotto.domain.LottoPublisher;

public record LottoNumber(int value) {
    public LottoNumber(String input) {
        this(validateLottoNumber(input));
    }

    private static int validateLottoNumber(String input) {
        validateNumberRange(input);
        return Integer.parseInt(input);
    }

    private static void validateNumberRange(String input) {
        if (isOutOfLottoRange(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_ERROR);
        }
    }

    private static boolean isOutOfLottoRange(String input) {
        return Integer.parseInt(input) < LottoPublisher.LOTTO_RANGE_MIN
                || Integer.parseInt(input) > LottoPublisher.LOTTO_RANGE_MAX;
    }
}
