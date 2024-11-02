package lotto.domain;

import static lotto.domain.LottoNumberRange.excludeRange;
import static lotto.message.ErrorMessage.ERROR_LOTTO_BONUS_NUMBER_RANGE;

public class LottoBonusNumber {

    private final int number;

    public LottoBonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (excludeRange(number)) {
            throw new IllegalArgumentException(ERROR_LOTTO_BONUS_NUMBER_RANGE.message());
        }
    }
}
