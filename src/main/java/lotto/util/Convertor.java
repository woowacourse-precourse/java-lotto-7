package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.validator.InputValidator;

public class Convertor {
    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> arrayToList(String[] input) {
        validateNull(input);
        validateNumberFormat(input);
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateNull(String[] input) {
        for (int i = 0; i < input.length; ++i) {
            InputValidator.validateNull(input[i]);
        }
    }

    private static void validateNumberFormat(String[] input) {
        for (int i = 0; i < input.length; ++i) {
            InputValidator.validateInteger(input[i]);
        }
    }
}
