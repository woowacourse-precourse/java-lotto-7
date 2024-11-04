package lotto.model.lottery;

import static lotto.common.Constants.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Winning {
    private static final String EMPTY_ELEMENT_ERROR = ERROR_HEADER + "쉼표 사이의 빈 문자가 입력되서는 안 됩니다.";
    private static final String WINNING_NUMBER_PATTERN = "^(\\d+)(,\\d+)*$";

    private final List<Integer> numbers;

    private Winning(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Winning from(String input) {
        validate(input);
        try {
            List<Integer> numbers = parse(input);
            return new Winning(numbers);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE_ERROR);
        }
        if (isDuplicateExisted(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
        if (isNotInRange(numbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
        }
    }

    private boolean isDuplicateExisted(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        return noDuplicateNumbers.size() != numbers.size();
    }

    private boolean isNotInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    private static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR);
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
        if (isEmptyElementContained(input)) {
            throw new IllegalArgumentException(EMPTY_ELEMENT_ERROR);
        }
    }

    private static boolean isEmptyElementContained(String input) {
        return !input.matches(WINNING_NUMBER_PATTERN);
    }

    private static List<Integer> parse(String input) {
        return Stream.of(input.split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
