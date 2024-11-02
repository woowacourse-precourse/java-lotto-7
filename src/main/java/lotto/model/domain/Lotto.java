package lotto.model.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ExceptionMessage;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        Set<Integer> forValidateDuplication = new HashSet<>();
        for (int number : numbers) {
            validateNumberAreaOf(number);
            validateNumberDuplication(forValidateDuplication, number);
        }
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_LENGTH_EXCEPTION);
        }
    }

    private void validateNumberAreaOf(int number) {
        boolean isInvalidNumberArea = number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
        if (isInvalidNumberArea) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_AREA_EXCEPTION);
        }
    }

    private void validateNumberDuplication(Set<Integer> forValidateDuplication, int number) {
        boolean isDuplicated = !forValidateDuplication.add(number);
        if (isDuplicated) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_DUPLICATION_EXCEPTION);
        }
    }
}
