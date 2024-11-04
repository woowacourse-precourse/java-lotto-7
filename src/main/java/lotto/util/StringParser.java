package lotto.util;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorStatus;
import lotto.exception.handler.ParseErrorHandler;

public class StringParser {
    private static final String delimiter = ",";

    public static Integer toNumber(String string) {
        try {
            return parseInt(string);
        } catch (NumberFormatException e) {
            throw new ParseErrorHandler(ErrorStatus.NUMBER_PARSE_ERROR);
        }
    }

    public static List<Integer> toNumbers(String string) {
        try {
            return Arrays.stream(string.split(delimiter))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new ParseErrorHandler(ErrorStatus.NUMBERS_PARSE_ERROR);
        }
    }
}
