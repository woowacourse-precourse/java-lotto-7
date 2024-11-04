package lotto.parser.util;

import lotto.exception.ExceptionMessages;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {

    public static List<Integer> convertToNumbers(List<String> inputs) {
        List<Integer> convertedNumbers = new ArrayList<>();
        for (String input : inputs) {
            int parsedInput = validateParseNumberAndReturn(input);
            convertedNumbers.add(parsedInput);
        }
        return convertedNumbers;
    }

    public static List<String> removeWhitespaceAndFormat(String[] inputs) {
        List<String> trimmedWinNumbers = new ArrayList<>();
        for (String input : inputs) {
            trimmedWinNumbers.add(input.trim());
        }
        return trimmedWinNumbers;
    }

    public static int convertToNumber(String input) {
        return validateParseNumberAndReturn(input);
    }

    private static int validateParseNumberAndReturn(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_FORMAT_ERROR + input);
        }
    }
}
