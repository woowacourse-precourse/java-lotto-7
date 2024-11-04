package lotto.domain;

import static lotto.constant.Error.DUPLICATED_WINNING_BONUS_NUMBERS;
import static lotto.constant.Error.DUPLICATED_WINNING_NUMBERS;
import static lotto.constant.Error.RANGE_BONUS_NUMBER;
import static lotto.constant.Error.RANGE_WINNING_NUMBER;
import static lotto.constant.Error.SIZE_WINNING_NUMBERS;
import static lotto.validation.NumbersValidation.validateAllRange;
import static lotto.validation.NumbersValidation.validateDuplicate;
import static lotto.validation.NumbersValidation.validateRange;
import static lotto.validation.NumbersValidation.validateSize;

import java.util.List;

public class Winning {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank rank(Lotto lotto) {
        int hitCount = (int) numbers
            .stream()
            .filter(lotto::hasNumber)
            .count();
        boolean hitsBonusNumber = lotto.hasNumber(bonusNumber);

        return Rank.of(hitCount, hitsBonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateSize(numbers, SIZE_WINNING_NUMBERS);
        validateDuplicate(numbers, DUPLICATED_WINNING_NUMBERS);
        validateAllRange(numbers, RANGE_WINNING_NUMBER);
        validateRange(bonusNumber, RANGE_BONUS_NUMBER);

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_BONUS_NUMBERS);
        }
    }
}
