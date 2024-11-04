package lotto.model;

import lotto.common.ExceptionConstant;
import lotto.common.LottoConstant;

public record LottoNumber(int number) {
    public LottoNumber {
        validateRange(number);
    }

    public static LottoNumber valueOf(String number) {
        try {
            return new LottoNumber(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE+ ExceptionConstant.LOTTO_NUMBER_MESSAGE+ "정수여야 합니다.");
        }
    }

    private void validateRange(int number) {
        if (number < LottoConstant.LOTTO_MIN_NUMBER || number > LottoConstant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE+ ExceptionConstant.LOTTO_NUMBER_MESSAGE+ LottoConstant.LOTTO_MIN_NUMBER+" 부터 "+ LottoConstant.LOTTO_MAX_NUMBER+" 사이여야 합니다.");
        }
    }


}
