package lotto.validation;

import java.util.List;
import lotto.util.enums.ValidateMessage;

public class NumberValidator {
    private static final String NUMBER_REGX = "[0-9]";

    public static void validateLottoNumberString(List<String> numbers) {
        boolean isAllNumber = numbers.stream()
                .allMatch(number -> number.matches(NUMBER_REGX));
        if (!isAllNumber) {
            throw new IllegalArgumentException(ValidateMessage.NON_NUMERIC_ERROR.getMessage());
        }
    }
}
