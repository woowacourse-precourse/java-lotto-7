package lotto.domain;

import java.util.List;

import static lotto.config.message.LottoErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (validateLottoSize(numbers)) {
            throw new IllegalArgumentException(SIZE_ERROR.getMessage());
        }
        if (validateLottoDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR.getMessage());
        }
        if (validateLottoRange(numbers)) {
            throw new IllegalArgumentException(RANGE_ERROR.getMessage());
        }
    }

    private static boolean validateLottoSize(List<Integer> numbers) {
        return numbers.size() != LottoRule.LOTTO_SIZE.getValue();
    }

    private static boolean validateLottoDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    private boolean validateLottoRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number ->
                        number < LottoRule.LOTTO_MIN_NUMBER.getValue() ||
                        number > LottoRule.LOTTO_MAX_NUMBER.getValue()
                );
    }

    public int matchCount(List<Integer> winNumber, int bonusNumber) {
        return (int) numbers.stream()
                .filter(number -> winNumber.contains(number) || number == bonusNumber)
                .count();
    }

    public boolean contain(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
