package lotto.domain;

import static lotto.constant.LottoValues.NUMBER_MAX;
import static lotto.constant.LottoValues.NUMBER_MIN;
import static lotto.message.ErrorMessage.LOTTO_SCOPE_ERROR;

public record LottoNumber(int number) {
    public LottoNumber {
        validateScope(number);
    }

    private void validateScope(int number) {
        boolean result = number >= NUMBER_MIN.value() && number <= NUMBER_MAX.value();
        if (!result) {
            throw new IllegalArgumentException(LOTTO_SCOPE_ERROR.getMessage());
        }
    }

    public boolean isSame(LottoNumber number) {
        return this.number == number.number();
    }
}
