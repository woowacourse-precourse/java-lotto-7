package lotto.validator;

import java.util.List;
import lotto.constant.Constant;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Validator {

    public static void validateBlank(String input, ErrorMessage errorMessage) {
        if (input == null || input.isBlank()) {
            throw new LottoException(errorMessage.getMessage());
        }
    }

    public static void validateNumeric(String input, ErrorMessage errorMessage) {
        if (!input.matches(Constant.NUMERIC_PATTERN)) {
            throw new LottoException(errorMessage.getMessage());
        }
    }

    public static void validateNumberRange(Integer number, ErrorMessage errorMessage) {
        if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
            throw new LottoException(errorMessage.getMessage());
        }
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            throw new LottoException(ErrorMessage.NOT_LOTTO_NUMBER_COUNT_SIX.getMessage());
        }
    }

    public static void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> validateNumberRange(number, ErrorMessage.OUT_RANGE_LOTTO_NUMBER));
    }

    public static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new LottoException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }
}
