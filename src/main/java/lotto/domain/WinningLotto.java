package lotto.domain;

import java.util.List;
import lotto.enums.LottoError;

public class WinningLotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    private WinningLotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static WinningLotto from(List<Integer> numbers) {
        return new WinningLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateDuplicationNumbers(numbers);
        validateLottoNumberCount(numbers.size());
        numbers.stream().forEach(number -> {
            validateMoreThanLottoNumberMin(number);
            validateLessThanLottoNumberMax(number);
        });
    }

    private void validateDuplicationNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LottoError.LOTTO_WINNING_NUMBERS_DUPLICATION.getMessage());
        }
    }

    private void validateMoreThanLottoNumberMin(int number) {
        if (number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanLottoNumberMax(int number) {
        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage());
        }
    }

    private void validateLottoNumberCount(int numberCount) {
        if (numberCount != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }
}
