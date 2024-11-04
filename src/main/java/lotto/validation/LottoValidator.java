package lotto.validation;

import java.util.List;

import static lotto.common.constant.ErrorMessage.*;

public class LottoValidator {

    private static final Integer lottoNumberSize = 6;

    public static void validateLotto(List<Integer> numbers){
        throwExceptionIfListSizeIsInvalid(numbers);
    }

    private static void throwExceptionIfListSizeIsInvalid(List<Integer> numbers) {
        if (numbers.size() != lottoNumberSize) {
            throw new IllegalArgumentException(LOTTO_SHOULD_BE_SIX.getErrorMessage());
        }
    }
}
