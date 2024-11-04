package lotto.model;

import lotto.exception.ErrorCode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final String LOTTO_DELIMITER = ",";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static Lotto of(String rawNumbers) {
        String[] winningNumberStrings = rawNumbers.split(LOTTO_DELIMITER);
        try {
            List<Integer> winningNumbers = Arrays.stream(winningNumberStrings)
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBERS_NOT_A_NUMBER.getMessage());
        }
    }

    public boolean containsNumber(int numberToCheck) {
        return numbers.contains(numberToCheck);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersRange(numbers);
        validateNumberSize(numbers);
        validateNumbersDuplicate(numbers);
    }

    private void validateNumberSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }
}
