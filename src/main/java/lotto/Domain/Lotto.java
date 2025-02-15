package lotto.Domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String NUMBERS_SIZE_NOT_SIX = "발행 로또 번호의 개수는 6개여야합니다.";
    private static final String NUMBERS_DUPLICATE_EXCEPTION = "발행 로또 번호는 중복될 수 없습니다.";
    private static final String NUMBERS_WRONG_RANGE_EXCEPTION = "발행 로또 번호는 1~45의 범위여야합니다.";
    private static final int CORRECT_NUMBERS_SIZE = 6;
    private static final String ERROR = "[ERROR] ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascendingSortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isNumbersSizeNotSix(numbers)) {
            throw new IllegalArgumentException(ERROR + NUMBERS_SIZE_NOT_SIX);
        }
        if (isNumbersDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR + NUMBERS_DUPLICATE_EXCEPTION);
        }
        if (isNumbersWrongRange(numbers)) {
            throw new IllegalArgumentException(ERROR + NUMBERS_WRONG_RANGE_EXCEPTION);
        }
    }

    private boolean isNumbersSizeNotSix(List<Integer> numbers) {
        return numbers.size() != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersDuplicate(List<Integer> numbers) {
        long numbersDistinctSize = numbers.stream()
                .distinct().count();
        return numbersDistinctSize != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersWrongRange(List<Integer> numbers) {
        long correntNumbersRangeCount = numbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .count();
        return correntNumbersRangeCount != CORRECT_NUMBERS_SIZE;
    }

    private List<Integer> ascendingSortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}