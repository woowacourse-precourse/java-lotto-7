package lotto.util.validator;

import lotto.exception.LottoError;
import lotto.exception.LottoException;

import java.util.List;

public final class LottoValidator {

    private static final int LOTTO_NUMBER_START_CRITERIA = 1;
    private static final int LOTTO_NUMBER_END_CRITERIA = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private LottoValidator() {
    }

    public static void validateNumber(final Integer number) {
        validateNumberRange(List.of(number));
    }
    public static void validateNumbers(final List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberUnique(numbers);
        validateNumberRange(numbers);
    }

    private static void validateNumberRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_START_CRITERIA || number > LOTTO_NUMBER_END_CRITERIA) {
                throw new LottoException(LottoError.NUMBER_OUT_OF_RANGE);
            }
        }
    }

    private static void validateNumberUnique(final List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (numbers.size() != uniqueCount) {
            throw new LottoException(LottoError.NUMBER_DUPLICATED);
        }
    }

    private static void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoException(LottoError.NUMBERS_WRONG_SIZE);
        }
    }


}
