package lotto.domain.winning;

import static lotto.constant.Error.DUPLICATED_WINNING_NUMBERS;
import static lotto.constant.Error.RANGE_WINNING_NUMBER;
import static lotto.constant.Error.SIZE_WINNING_NUMBERS;
import static lotto.validation.NumbersValidation.validateAllRange;
import static lotto.validation.NumbersValidation.validateDuplicate;
import static lotto.validation.NumbersValidation.validateSize;

import java.util.List;
import lotto.domain.Lotto;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countHit(Lotto lotto) {
        return (int) numbers
            .stream()
            .filter(lotto::hasNumber)
            .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers, SIZE_WINNING_NUMBERS);
        validateDuplicate(numbers, DUPLICATED_WINNING_NUMBERS);
        validateAllRange(numbers, RANGE_WINNING_NUMBER);
    }
}
