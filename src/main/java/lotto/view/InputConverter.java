package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.io.InputValidation;

public final class InputConverter {

    private static final String NUMBERS_DELIMITER = ",";

    private InputConverter() {
    }

    public static List<Integer> convertToNumbers(String input) {
        validate(input);
        InputValidation.validateDelimiter(input);

        String[] splitNumbers = splitNumberByDelimiter(input);

        List<Integer> numbers = new ArrayList<>();
        for (String number : splitNumbers) {
            int parseNumber = parseInt(number);
            numbers.add(parseNumber);
        }
        return numbers;
    }

    public static int parseToNumber(String input) {
        validate(input);
        InputValidation.validateNumeric(input);
        return parseInt(input);
    }

    private static void validate(String input) {
        InputValidation.validateNullOrEmpty(input);
        InputValidation.validateContainBlank(input);
    }

    private static String[] splitNumberByDelimiter(String input) {
        return input.split(NUMBERS_DELIMITER);
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
