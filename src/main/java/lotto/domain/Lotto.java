package lotto.domain;

import static lotto.handler.ConstantHandler.LOTTO_SIZE;
import static lotto.handler.ConstantHandler.MAX_LOTTO_NUMBER;
import static lotto.handler.ConstantHandler.MIN_LOTTO_NUMBER;
import static lotto.handler.ErrorHandler.INVALID_RANGE;
import static lotto.handler.ErrorHandler.INVALID_SIZE;
import static lotto.handler.ErrorHandler.INVALID_UNIQUE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw INVALID_SIZE.getException();
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw INVALID_UNIQUE.getException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    protected void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw INVALID_RANGE.getException();
        }
    }
}
