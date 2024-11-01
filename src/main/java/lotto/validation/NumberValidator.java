package lotto.validation;

import java.util.List;
import lotto.exception.InputException;

public class NumberValidator {
    private static final String NUMBER_REGX = "[0-9]";

    public static void validateMultiNumberInput(List<String> numbers) {
        boolean isAllNumeric = numbers.stream()
                .allMatch(NumberValidator::isInputNumber);
        InputException.notNumericException(isAllNumeric);
    }

    public static boolean isInputNumber(String number) {
        boolean isNumeric = number.matches(NUMBER_REGX);
        InputException.notNumericException(isNumeric);
        return true;
    }
}
