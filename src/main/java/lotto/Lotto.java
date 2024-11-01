package lotto;

import static lotto.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.MessageContainer.COUNT_OF_LOTTO_NUMBERS_ERROR;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSizeOf(numbers);
        this.numbers = numbers;
    }

    private void validateSizeOf(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(COUNT_OF_LOTTO_NUMBERS_ERROR);
        }
    }
}
