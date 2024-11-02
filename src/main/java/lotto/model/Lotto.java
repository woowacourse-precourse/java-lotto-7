package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.controller.error.ErrorType;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = sort(numbers);
    }

    private List<Integer> sort(final List<Integer> numbers) {
        final List<Integer> modifiableList = new ArrayList<>(numbers);
        Collections.sort(modifiableList);
        return modifiableList;
    }

    public static Lotto fromStringList(final List<String> numbers) {
        return new Lotto(parseNumbers(numbers));
    }

    private static List<Integer> parseNumbers(final List<String> numbers) {
        try {
            return numbers.stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_FORMAT.getMessage(), e);
        }
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorType.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateRange(final List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorType.OUT_OF_RANGE.getMessage());
            }
        });
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
