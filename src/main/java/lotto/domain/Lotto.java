package lotto.domain;

import static lotto.constant.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.constant.ExceptionMessage.INVALID_SIZE;
import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.NUMBERS_PER_TICKET;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateSizeExact(numbers);
        validateNoDuplicate(numbers);
        validateNumbersInRange(numbers);

        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(List.copyOf(numbers));
    }

    private void validateSizeExact(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_PER_TICKET) {
            throw new IllegalArgumentException(String.format(INVALID_SIZE.format(), NUMBERS_PER_TICKET));
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_PER_TICKET) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.message());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateNumberInRange(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.format(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
