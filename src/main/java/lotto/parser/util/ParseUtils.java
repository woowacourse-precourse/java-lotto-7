package lotto.parser.util;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {

    public static List<Integer> convertToNumbers(List<String> inputs) {
        List<Integer> convertedNumbers = new ArrayList<>();
        for (String input : inputs) {
            int parsedInput = validateParseNumberAndReturn(input);
            convertedNumbers.add((parsedInput));
        }
        return convertedNumbers;
    }

    public static List<String> removeWhitespace(String[] inputs) {
        List<String> trimmedWinNumbers = new ArrayList<>();
        for (String input : inputs ) {
            trimmedWinNumbers.add(input.trim());
        }
        return trimmedWinNumbers;
    }

    public static int convertToNumber(String input) {
        return validateParseNumberAndReturn(input);
    }

    private static int validateParseNumberAndReturn(String input) {
        try {
            int parsedInput = Integer.parseInt(input);
            return parsedInput;
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 형식만 입력 가능합니다. 잘못된 형식: " + input);
        }
    }
}
