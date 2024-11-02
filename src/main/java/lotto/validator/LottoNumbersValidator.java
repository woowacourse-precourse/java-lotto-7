package lotto.validator;

import static lotto.exception.Exception.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.exception.Exception.LOTTO_NUMBER_SIZE_MUST_BE_SIX;

import java.util.List;

public class LottoNumbersValidator {

    public static void validate() {

    }

    private static void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_MUST_BE_SIX.getMessage());
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        boolean isValid = numbers.stream().allMatch(number -> number >= 1 && number <= 45);
        if (!isValid) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}