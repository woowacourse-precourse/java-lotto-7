package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        return distinctCount != numbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}