package lotto.domain;

import static lotto.util.Constants.ERROR_PREFIX;

import java.util.List;

public class Lotto {
    private static final String LOTTO_COUNT_ERROR_MESSAGE = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE = ERROR_PREFIX + "로또 번호에 중복된 숫자가 있습니다.";
    private static final String RANGE_ERROR_MESSAGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이여야 합니다.";
    private static final int REQUIRED_LOTTO_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedAscendingNumbers() {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public boolean hasNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public long matchCount(Lotto winningLotto) {
        return numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoCount(numbers);
        validateDuplicateNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

}
