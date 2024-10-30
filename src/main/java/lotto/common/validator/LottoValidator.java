package lotto.common.validator;

import lotto.error.LottoErrorMessage;

import java.util.List;

public class LottoValidator {
    public static void validate(List<String> numbers) {
        checkSize(numbers);
    }

    private static void checkSize(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.UNMATCHED_SIZE
                    .getMessage());
        }
    }
}
