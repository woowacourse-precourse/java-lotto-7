package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.util.enums.ValidateMessage;

public class Lotto {
    private static final int FIFTY_FIVE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
        validateOverThanFiftyFive(numbers);
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

    public static void validateOverThanFiftyFive(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number >= FIFTY_FIVE) {
                throw new IllegalArgumentException(ValidateMessage.NUMBER_RANGE_ERROR.getMessage());
            }
        });
    }
}
