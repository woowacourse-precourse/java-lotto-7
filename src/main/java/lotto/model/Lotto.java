package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String ERROR_SIZE_MESSAGE = "[ERROR] 로또 번호는 " + REQUIRED_NUMBER_COUNT + "개여야 합니다.";
    private static final String ERROR_DUPLICATE_MESSAGE = "[ERROR] 중복된 숫자가 있습니다.";
    private static final String ERROR_RANGE_MESSAGE = "[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + "사이여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_SIZE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR_RANGE_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
