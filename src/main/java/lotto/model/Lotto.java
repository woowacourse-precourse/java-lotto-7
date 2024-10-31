package lotto.model;

import java.util.List;
import lotto.exception.LottoErrorMessage;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberRange(numbers);
        validateNumberDuplicate(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
            }
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        var distinctNumbers = numbers.stream().distinct().count();
        if (distinctNumbers == LOTTO_SIZE) {
            return;
        }

        throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }
}
