package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessage;

public class SizeValidator {
    public static void validate(List<Integer> number) {
        if (number.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WIN_NUMBER_SIZE.getMessage());
        }
    }
}
