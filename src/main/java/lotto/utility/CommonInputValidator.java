package lotto.utility;

import java.util.List;
import lotto.constant.RegularExpression;

public class CommonInputValidator {

    public static String EMPTY_INPUT = "비어있는 값은 허용하지 않습니다.";
    public static String NON_NUMERIC_INPUT = "숫자가 아닌 값은 허용하지 않습니다.";
    public static String OUT_OF_PARSE_RANGE = "범위를 벗어난 값은 허용하지 않습니다.";

    public static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    public static void isNonNumeric(String input) {
        if (!input.matches(RegularExpression.INTEGER_PATTERN.getExpression())) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT);
        }
    }

    public static void isOutOfParseRange(String numericInput) {
        try {
            Integer.parseInt(numericInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(OUT_OF_PARSE_RANGE);
        }
    }

    public static void hasBlankElement(String separableInput, String delimiter) {
        if (separableInput.startsWith(delimiter) || separableInput.endsWith(delimiter)) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
        List<String> elements = List.of(separableInput.split(delimiter));
        for (String element : elements) {
            isBlank(element);
        }
    }

    public static void existNonNumericElement(String separableInput, String delimiter) {
        List<String> elements = List.of(separableInput.split(delimiter));
        for (String element : elements) {
            isNonNumeric(element);
        }
    }

    public static void existOutOfParseRangeElement(String separableInput, String delimiter) {
        List<String> elements = List.of(separableInput.split(delimiter));
        for (String element : elements) {
            isOutOfParseRange(element);
        }
    }
}
