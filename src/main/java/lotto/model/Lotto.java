package lotto.model;

import lotto.exception.GameException;

import java.util.List;

import static lotto.exception.ErrorMessage.*;
import static lotto.model.LottoOption.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getSortedNumbersByAscending() {
        return numbers.stream()
            .sorted()
            .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkInRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != TOTAL_ELEMENT_COUNT.value()) {
            throw new GameException(INVALID_SIZE);
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new GameException(HAS_DUPLICATE_NUMBER);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private void checkInRange(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new GameException(OUT_OF_RANGE);
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
            .anyMatch(number -> number < MIN_NUMBER_OF_RANGE.value() || number > MAX_NUMBER_OF_RANGE.value());
    }

}
