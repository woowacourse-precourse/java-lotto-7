package lotto.model;

import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constant.ErrorMessage.INVALID_WINNING_NUMBER_COUNT;
import static lotto.constant.GameValue.MAX_LOTTO_NUMBER;
import static lotto.constant.GameValue.MIN_LOTTO_NUMBER;
import static lotto.constant.GameValue.NUMBER_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
