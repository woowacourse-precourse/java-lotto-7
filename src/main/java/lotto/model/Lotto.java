package lotto.model;

import lotto.exception.GameException;

import java.util.List;

public class Lotto {
    public static final int MIN_NUMBER_OF_RANGE = 1;
    public static final int MAX_NUMBER_OF_RANGE = 45;
    public static final int TOTAL_ELEMENT_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkInRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != TOTAL_ELEMENT_COUNT) {
            throw new GameException("로또 번호는 %s개여야 합니다.".formatted(TOTAL_ELEMENT_COUNT));
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new GameException("중복된 번호가 있습니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private void checkInRange(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new GameException("로또 번호는 %s부터 %s사이여야 합니다.".formatted(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE));
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MIN_NUMBER_OF_RANGE || number > MAX_NUMBER_OF_RANGE);
    }

}
