package lotto;

import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        validateCountOfNumbers(numbers);
        validateDuplicateNumber(numbers);
        validateRangeOfNumbers(numbers);
    }

    private static void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("\n[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(num -> num < Constants.LOTTO_NUMBER_MIN || num > Constants.LOTTO_NUMBER_MAX);
        if (isOutOfRange) {
            throw new IllegalArgumentException("\n[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        boolean isDuplicated = new HashSet<>(numbers).size() != Constants.LOTTO_NUMBERS_LENGTH;
        if(isDuplicated) {
            throw new IllegalArgumentException("\n[ERROR] 로또 번호는 중복이 없어야만 합니다.");
        }
    }
}
