package lotto;

import static lotto.ErrorCode.DUPLICATE_WINNIG_NUMBER;
import static lotto.ErrorCode.INVALID_NUMBER_RANGE;
import static lotto.ErrorCode.INVALID_WINNIG_NUMBER_COUNT;

import java.util.List;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int VALID_LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberRange(numbers);
        validateLottoNumberDuplicate(numbers);
        validateLottoNumberCount(numbers);
    }

    private void validateLottoNumberRange(final List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateLottoNumberDuplicate(final List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_WINNIG_NUMBER.getMessage());
        }
    }

    public static void validateLottoNumberCount(final List<Integer> numbers) {
        if (numbers.size() != VALID_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNIG_NUMBER_COUNT.getMessage());
        }
    }

    private static boolean hasDuplicates(final List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private static void validateNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
