package lotto;

import java.util.List;

import static lotto.Lotto.NUMBER_COUNT;
import static lotto.exception.ExceptionCode.DUPLICATED_NUMBER;
import static lotto.exception.ExceptionCode.INCORRECT_NUMBER_COUNTS;

public class WinningNumber {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplication(numbers);
        this.numbers = numbers.subList(0, NUMBER_COUNT);
        this.bonusNumber = numbers.get(NUMBER_COUNT);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT+1) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNTS.message());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.message());
        }
    }


}
