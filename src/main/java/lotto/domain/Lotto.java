package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numberSizeCheck(numbers);
        numberRangeCheck(numbers);
        numberAscendingSortedCheck(numbers);
        numberDuplicateCheck(numbers);
    }

    private static void numberSizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorConfig.LOTTO_SIZE_ERROR.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
    private static void numberRangeCheck(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number > 45 || number < 1)) {
            throw new IllegalArgumentException(LottoErrorConfig.LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private static void numberAscendingSortedCheck(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException(LottoErrorConfig.LOTTO_SORTING_ERROR.getErrorMessage());
            }
        }
    }

    private static void numberDuplicateCheck(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorConfig.LOTTO_DUPLICATED_ERROR.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
