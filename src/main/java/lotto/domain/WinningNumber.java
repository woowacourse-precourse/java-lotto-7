package lotto.domain;

import java.util.List;

import static lotto.domain.Lotto.NUMBER_COUNT;
import static lotto.exception.ExceptionCode.DUPLICATED_NUMBER;
import static lotto.exception.ExceptionCode.INCORRECT_NUMBER_COUNTS;

public class WinningNumber {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        validateCount(numbers);
        validateDuplication(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNTS.message());
        }
    }

    private void validateDuplication(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.message());
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.message());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
