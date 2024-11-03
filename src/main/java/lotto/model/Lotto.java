package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.CustomException;
import lotto.error.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new CustomException(ExceptionMessage.ERROR_MESSAGE_IS_NOT_VALID_LOTTO_NUMBERS);
        }
        if (isDuplicated(numbers)) {
            throw new CustomException(ExceptionMessage.ERROR_MESSAGE_DUPLICATED_LOTTO_NUMBER);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> numberNotDuplicated = new HashSet<>(numbers);
        return (numberNotDuplicated.size() != numbers.size());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
