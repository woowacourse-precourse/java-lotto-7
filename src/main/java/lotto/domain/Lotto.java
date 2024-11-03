package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.IS_INVALID_SIZE);
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.IS_DUPLICATED);
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() != numbers.size();
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
