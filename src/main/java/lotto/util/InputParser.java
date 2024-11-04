package lotto.util;

import static lotto.exception.printException.throwIllegalArgException;
import static lotto.util.InputValidator.validateInteger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;

public class InputParser {
    public static int parseInteger(String input) {
        validateInteger(input);
        return Integer.parseInt(input.trim());
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputParser::parseInteger)
                .collect(Collectors.toList());
    }
}
