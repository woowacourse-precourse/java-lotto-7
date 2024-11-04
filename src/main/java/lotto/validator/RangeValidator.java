package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessage;

public class RangeValidator {
    public static void validate(List<Integer> number) {
        if (number.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WIN_NUMBER_RANGE.getMessage());
        }
    }
}
