package lotto.domain;

import java.util.List;
import lotto.message.ExceptionMessage;

public record BonusNumber(int number) {

    public BonusNumber {
        validate(number);
    }

    private void validate(int number) {
        validateBonusInRange(number);

    }

    private void validateBonusInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }
}