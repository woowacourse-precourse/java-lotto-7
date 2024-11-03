package lotto;

import java.util.List;
import java.util.HashSet;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCountOfNumbers(numbers);
        validateDuplicateNumber(numbers);
        validateRangeOfNumbers(numbers);
    }

    private static void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX);
        if (isOutOfRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        boolean isDuplicated = new HashSet<>(numbers).size() != 6;
        if(isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야만 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
