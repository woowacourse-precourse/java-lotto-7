package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_EXCEED);
        }

        if (isDuplication(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS);
        }
    }

    private boolean isDuplication(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
