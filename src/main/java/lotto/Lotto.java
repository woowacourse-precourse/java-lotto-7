package lotto;

import static lotto.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBER_START = "[";
    private static final String LOTTO_NUMBER_END = "]";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numbers);
    }

    public String getFormatted() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER, LOTTO_NUMBER_START, LOTTO_NUMBER_END));
    }

    public int getMatchingCountWith(Winning winning) {
        List<Number> matchingNumber = new ArrayList<>(List.copyOf(this.numbers));
        matchingNumber.retainAll(winning.getNumbers());
        return matchingNumber.size();
    }

    public boolean isContained(Bonus bonus) {
        return this.numbers.contains(bonus.get());
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR);
        }
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
        return numbers.size() != new HashSet<>(numbers).size();
    }

    private boolean isNotInRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE);
    }
}
