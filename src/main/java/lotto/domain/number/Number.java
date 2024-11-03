package lotto.domain.number;

import static lotto.constant.LottoValues.LOTTO_NUMBER_MAX;
import static lotto.constant.LottoValues.LOTTO_NUMBER_MIN;
import static lotto.message.ErrorMessage.LOTTO_SCOPE_ERROR;

public abstract class Number {
    private final int number;

    public Number(int number) {
        validateScope(number);
        this.number = number;
    }

    private void validateScope(int number) {
        boolean result = number >= LOTTO_NUMBER_MIN.value() && number <= LOTTO_NUMBER_MAX.value();
        if (!result) {
            throw new IllegalArgumentException(LOTTO_SCOPE_ERROR.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean isSame(Number number) {
        return this.number == number.getNumber();
    }
}
