package lotto.domain;

import static lotto.error.ThrowException.throwIllegalArgumentException;

import lotto.error.Error;
import lotto.value.LottoValue;

public class BonusLotto {

    private final int bonusNumber;

    public BonusLotto(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        final int startNumberInclusive = LottoValue.START_NUMBER_INCLUSIVE.value();
        final int endNumberInclusive = LottoValue.END_NUMBER_INCLUSIVE.value();
        boolean validateRange = (bonusNumber < startNumberInclusive) ||
                (bonusNumber > endNumberInclusive);
        String errorFormat = Error.WRONG_LOTTO_NUMBER_RANGE.format(
                startNumberInclusive, endNumberInclusive);
        throwIllegalArgumentException(validateRange, errorFormat);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
