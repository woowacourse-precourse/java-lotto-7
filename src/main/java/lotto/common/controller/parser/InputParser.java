package lotto.common.controller.parser;

import static lotto.common.exception.ExceptionName.PARSE_INT;
import static lotto.common.exception.ExceptionName.PARSE_LIST_DELIMITER;
import static lotto.common.exception.ExceptionName.PARSE_LONG;
import static lotto.common.rule.Rule.LIST_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class InputParser {

    private InputParser() {
    }

    public static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_LONG);
        }
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_INT);
        }
    }

    public static List<Integer> parseIntegerList(String input) {
        try {
            return Arrays.stream(input.split(LIST_DELIMITER)).map(InputParser::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_INT);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(PARSE_LIST_DELIMITER);
        }
    }
}
