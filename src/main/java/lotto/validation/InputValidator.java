package lotto.validation;

import java.util.List;
import lotto.exception.InputException;

public class InputValidator {
    private static final String NUMBER_REGX = "^[1-9]\\d*$";

    public static void validateMultiNumberInput(List<String> numbers) {
        boolean isAllNumeric = numbers.stream()
                .allMatch(InputValidator::isInputNumber);
        InputException.notNumericException(isAllNumeric);
    }

    public static boolean isInputNumber(String number) {
        boolean isNumeric = number.matches(NUMBER_REGX);
        InputException.notNumericException(isNumeric);
        return true;
    }
}
