package lotto.validation;

import java.util.List;
import lotto.util.enums.ValidateMessage;

public class NumberValidator {
    private static final String NUMBER_REGX = "[0-9]";

    public static void validateLottoNumberString(List<String> numbers) {
        boolean isAllNumeric = numbers.stream()
                .allMatch(number -> number.matches(NUMBER_REGX));
        throwNotNumericException(isAllNumeric);
    }

    public static void validateBonusNumberString(String number) {
        boolean isNumeric = number.matches(NUMBER_REGX);
        throwNotNumericException(isNumeric);
    }
    
    private static void throwNotNumericException(boolean isNumeric) {
        if (!isNumeric) {
            throw new IllegalArgumentException(ValidateMessage.NON_NUMERIC_ERROR.getMessage());
        }
    }
}
