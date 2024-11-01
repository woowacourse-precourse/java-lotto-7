package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.validator.InputValidator;

public class Convertor {
    public static int stringToInt(final String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> arrayToList(final String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void validateNull(final String[] input) {
        for (int i = 0; i < input.length; ++i) {
            InputValidator.validateNull(input[i]);
        }
    }

    public static void validateNumberFormat(final String[] input) {
        for (int i = 0; i < input.length; ++i) {
            InputValidator.validateInteger(input[i]);
        }
    }
}