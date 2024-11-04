package lotto.domain;

import static lotto.constant.ApplicationConstants.LOTTO_RANGE_MAX;
import static lotto.constant.ApplicationConstants.LOTTO_RANGE_MIN;

import java.util.List;
import lotto.enums.ErrorMessage;

public class BonuseNumber {
    private final Integer number;

    public BonuseNumber(Integer number, List<Integer> numbers) {
        validate(number, numbers);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void validate(Integer number, List<Integer> numbers) {
        validateRange(number);
        validateDuplicate(number, numbers);
    }

    private void validateRange(Integer number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicate(Integer number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
