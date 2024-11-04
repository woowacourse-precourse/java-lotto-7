package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int REQUIRED_SIZE = 6;
    private static final int MAX_LOTTO_LIST_SIZE = 1000;

    private static final String ERROR_NULL = "[ERROR] 로또 번호는 null일 수 없습니다.";
    private static final String ERROR_EMPTY = "[ERROR] 로또 번호가 비어있습니다.";
    private static final String ERROR_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 중복된 숫자가 있습니다.";
    private static final String ERROR_LIST_SIZE = "[ERROR] 로또 리스트가 너무 큽니다.";

    private LottoNumberValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateNull(numbers);
        validateEmpty(numbers);
        validateListSize(numbers);
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERROR_NULL);
        }
    }

    private static void validateEmpty(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY);
        }
    }

    private static void validateListSize(List<Integer> numbers) {
        if (numbers.size() > MAX_LOTTO_LIST_SIZE) {
            throw new IllegalArgumentException(ERROR_LIST_SIZE);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_RANGE);
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }
}