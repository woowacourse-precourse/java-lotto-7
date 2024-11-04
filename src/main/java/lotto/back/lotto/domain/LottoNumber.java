package lotto.back.lotto.domain;

import lotto.global.exception.CustomIllegalArgumentException;
import lotto.back.lotto.config.LottoConfig;

public record LottoNumber(Integer number) {

    public LottoNumber {
        validateNumberRange(number);
    }

    private void validateNumberRange(Integer number) {
        if (number < LottoConfig.MIN_NUMBER.get() || LottoConfig.MAX_NUMBER.get() < number) {
            throw new CustomIllegalArgumentException(String.format(
                    "로또 번호는 %d부터 %d 사이여야 합니다.",
                    LottoConfig.MIN_NUMBER.get(),
                    LottoConfig.MAX_NUMBER.get()
            ));
        }
    }
}
