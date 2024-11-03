package lotto;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String NUMBER_REGEX = "^\\s*-?\\d+\\s*$";
    private static final String DEFAULT_DELIMITER = ",";
    private static final String NUMBER_WITH_DELIMITER_REGEX_PREFIX = "^\\s*-?\\d+(\\s*";
    private static final String NUMBER_WITH_DELIMITER_REGEX_SUFFIX = "\\s*-?\\d+)*\\s*$";

    public static int parseInt(String input) {
        String strippedInput = input.strip();
        emptyCheck(strippedInput);
        numberCheck(strippedInput);
        integerRangeCheck(strippedInput);
        return Integer.parseInt(strippedInput);
    }

    public static List<Integer> parseIntList(String input) {
        return parseIntList(input, DEFAULT_DELIMITER);
    }

    public static List<Integer> parseIntList(String input, String delimiter) {
        String regex = NUMBER_WITH_DELIMITER_REGEX_PREFIX + delimiter + NUMBER_WITH_DELIMITER_REGEX_SUFFIX;
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.format(delimiter));
        }

        String[] inputs = input.split(delimiter);
        return Arrays.stream(inputs)
                .map(InputParser::parseInt)
                .toList();
    }

    private static void emptyCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.format());
        }
    }

    private static void numberCheck(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.format());
        }
    }

    private static void integerRangeCheck(String input) {
        BigInteger number = new BigInteger(input);
        BigInteger min = BigInteger.valueOf(Integer.MIN_VALUE);
        BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);

        if (number.compareTo(min) < 0 || number.compareTo(max) > 0) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.format(Integer.MIN_VALUE, Integer.MAX_VALUE));
        }
    }
}
