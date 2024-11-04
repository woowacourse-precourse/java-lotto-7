package lotto.domain;

import static lotto.constants.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MINIMUM_LOTTO_NUMBER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        checkNumbersCount(numbers);
        checkDuplication(numbers);
        checkNumbersRange(numbers);
    }

    private void checkNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        long numbersCount = numbers.stream().
                distinct().
                count();
        if (numbersCount != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void checkNumbersRange(List<Integer> numbers) {
        numbers.stream().
                forEach(number -> {
                    checkSingleNumberRange(number);
                });
    }

    private void checkSingleNumberRange(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER)
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
