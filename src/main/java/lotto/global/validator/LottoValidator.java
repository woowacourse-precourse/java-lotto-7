package lotto.global.validator;

import lotto.global.constant.LottoConstant;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

import java.util.List;

public class LottoValidator {

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateNumberRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE) {
            throw LottoException.from(ErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private static void validateDuplication(final List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_INPUT);
        }
    }

    private static void validateNumberRange(final List<Integer> numbers) {
        for (int number : numbers) {
            validatePositiveNumber(number);
            validateNumberInRange(number);
        }
    }

    private static void validatePositiveNumber(final int number) {
        if (number <= 0) {
            throw LottoException.from(ErrorMessage.INVALID_NEGATIVE_NUMBER);
        }
    }

    private static void validateNumberInRange(final int number) {
        if (number < LottoConstant.MIN_LOTTO_NUMBER || number > LottoConstant.MAX_LOTTO_NUMBER) {
            throw LottoException.from(ErrorMessage.INVALID_LOTTO_RANGE);
        }
    }

    private static boolean isDuplicated(final List<Integer> numbers) {
        return getSize(numbers) != numbers.size();
    }

    private static int getSize(final List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }
}