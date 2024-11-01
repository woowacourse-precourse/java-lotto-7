package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.util.enums.ValidateMessage;
import lotto.validation.NumberValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
        NumberValidator.validateNumberCondition(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ValidateMessage.NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        Set<Integer> distinctNumbers = Set.copyOf(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(ValidateMessage.DUPLICATE_ERROR.getMessage());
        }
    }
}
