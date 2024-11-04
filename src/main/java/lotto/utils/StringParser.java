package lotto.utils;

import lotto.error.ErrorStatus;
import lotto.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    private static final String DELIMITER = ",";
    private static final String GAP = " ";
    private static final String START_POINT = "[";
    private static final String END_POINT = "]";

    public static int parseStringToInt(String input) {
        Validation.validateNotNull(input);
        int parsedInput = parseInteger(input);
        Validation.validatePositiveInteger(parsedInput);
        return parsedInput;
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_INPUT_INTEGER.getMessage());
        }
    }

    public static List<Integer> parseStringToIntegerList(String input) {
        String[] inputArray = splitInputString(input);
        Validation.validateNumberSize(inputArray.length);

        List<Integer> parsedInput = convertToIntegerList(inputArray);

        Validation.validatePositiveIntegerList(parsedInput);
        Validation.validateDuplicateNumbers(parsedInput);
        return convertToIntegerList(inputArray);
    }

    private static String[] splitInputString(String input) {
        return input.split(DELIMITER);
    }

    private static List<Integer> convertToIntegerList(String[] inputArray) {
        List<Integer> result = new ArrayList<>();
        for (String s : inputArray) {
            result.add(parseInteger(s));
        }
        return result;
    }

    public static String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER + GAP, START_POINT, END_POINT));
    }
}
