package lotto.domain;

import static lotto.constant.ErrorMessage.NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.NUMBER_SIZE_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int getMatchedCount(List<Integer> inputNumbers) {
        return countMatchingNumbers(inputNumbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (hasNumberOutOfRange(numbers)) {
            throw new IllegalArgumentException(
                    String.format(NUMBER_RANGE_ERROR_MESSAGE.getMessage(), MIN_RANGE, MAX_RANGE));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    private int countMatchingNumbers(List<Integer> inputNumbers) {
        int matchedCount = 0;
        for (Integer number : inputNumbers) {
            if (isNumberInList(number)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private boolean isNumberInList(Integer number) {
        return Collections.binarySearch(this.numbers, number) >= 0;
    }

    private boolean hasNumberOutOfRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isNumberOutOfRange);
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        return getDistinctNumberCount(numbers) != numbers.size();
    }

    private boolean isNumberOutOfRange(Integer number) {
        return number < MIN_RANGE || number > MAX_RANGE;
    }

    private long getDistinctNumberCount(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
