package lotto.domain;

import static lotto.domain.LottoNumberRange.excludeRange;
import static lotto.message.ErrorMessage.EXCLUDE_BONUS_RANGE;

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
            throw new IllegalArgumentException(EXCLUDE_BONUS_RANGE.message());
        }
    }
}
