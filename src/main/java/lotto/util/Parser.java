package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Parser {
    private static final String DELIMITER = ",";

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessage.TOO_BIG_INPUT.getMessage());
        }
    }

    public static List<String> parseStringList(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public static List<Integer> parseIntegerList(List<String> input) {
        return input.stream()
                .map(Parser::parseInt)
                .collect(Collectors.toList());
    }
}
