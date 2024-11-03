package lotto.utils.parser;

import static lotto.exception.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersInputParser {

    private static final String DELIMITER = ",";

    private LottoNumbersInputParser() {
    }

    public static List<Integer> parse(String input) {
        validateInput(input);
        return splitAndConvertToNumbers(input);
    }

    private static void validateInput(String input) {
        checkNotNull(input);
        checkNotEmpty(input);
        checkCommaPosition(input);
    }

    private static void checkNotNull(String input) {
        if (input == null) {
            throw new NullPointerException(NULL_INPUT.getMessage());
        }
    }

    private static void checkNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static void checkCommaPosition(String input) {
        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(INVALID_COMMA_POSITION.getMessage());
        }
    }

    private static List<Integer> splitAndConvertToNumbers(String input) {
        List<String> parts = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        validateParts(parts);
        return toIntegerList(parts);
    }

    private static void validateParts(List<String> parts) {
        for (String part : parts) {
            if (part.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_PART_INPUT.getMessage());
            }
            validateNumberFormat(part);
        }
    }

    private static void validateNumberFormat(String part) {
        try {
            Integer.parseInt(part);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_VALUE_INPUT.getMessage());
        }
    }

    private static List<Integer> toIntegerList(List<String> parts) {
        return parts.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
