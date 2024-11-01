package lotto.model;

import static lotto.constant.core.ParserConstant.*;
import static lotto.constant.message.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static Integer parseInputToInt(String input) {
        String trimmedInput = trimWhitespace(input);
        return convertStringToInteger(trimmedInput);
    }

    public static List<Integer> parseInputsToIntList(String inputs) {
        List<Integer> parsedInputs = new ArrayList<>();
        List<String> separatedInputs = separateBySeparator(inputs);
        for (String input : separatedInputs) {
            String trimmedInput = trimWhitespace(input);
            Integer convertedInput = convertStringToInteger(trimmedInput);
            parsedInputs.add(convertedInput);
        }
        return parsedInputs;
    }

    private static String trimWhitespace(String input) {
        return input.trim();
    }

    private static Integer convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }

    private static List<String> separateBySeparator(String inputs) {
        String[] separatedInputs = inputs.split(PLURAL_INPUT_SEPARATOR.getStringValue());
        return Arrays.asList(separatedInputs);
    }
}
