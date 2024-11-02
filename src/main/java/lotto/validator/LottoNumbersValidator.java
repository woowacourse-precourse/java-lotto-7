package lotto.validator;

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
}