package lotto.model;

import lotto.constant.Constant;

public record LottoNumber(int number) {
    public LottoNumber {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (number < Constant.LOTTO_MIN_NUMBER || number > Constant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE+Constant.LOTTO_NUMBER_MESSAGE+Constant.LOTTO_MIN_NUMBER+" 부터 "+Constant.LOTTO_MAX_NUMBER+" 사이여야 합니다.");
        }
    }
}
