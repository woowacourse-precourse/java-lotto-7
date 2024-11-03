package lotto.utils;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersInputParser {

    private static final String DELIMITER = ",";

    private LottoNumbersInputParser() {
    }

    public static List<Integer> parseLottoNumbers(String input) {
        validate(input);
        return parseNumbersFromString(input);
    }

    private static void validate(String input) {
        validateLottoNumbersNotNull(input);
        validateLottoNumbersNotEmpty(input);
        validateCommaPosition(input);
    }

    private static void validateLottoNumbersNotNull(String input) {
        if (input == null) {
            throw CustomIllegalArgumentException.from(NULL_INPUT);
        }
    }

    private static void validateLottoNumbersNotEmpty(String input) {
        if (input.isEmpty()) {
            throw CustomIllegalArgumentException.from(EMPTY_INPUT);
        }
    }

    private static void validateCommaPosition(String input) {
        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw CustomIllegalArgumentException.from(INVALID_COMMA_POSITION);
        }
    }

    private static List<Integer> parseNumbersFromString(String input) {
        List<String> parts = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        validateParts(parts);
        return convertPartsToNumbers(parts);
    }

    private static void validateParts(List<String> parts) {
        for (String part : parts) {
            if (part.isEmpty()) {
                throw CustomIllegalArgumentException.from(EMPTY_PART_INPUT);
            }
            validateNumber(part);
        }
    }

    private static void validateNumber(String part) {
        try {
            Integer.parseInt(part);
        } catch (NumberFormatException e) {
            throw CustomIllegalArgumentException.from(INVALID_VALUE_INPUT);
        }
    }

    private static List<Integer> convertPartsToNumbers(List<String> parts) {
        return parts.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
