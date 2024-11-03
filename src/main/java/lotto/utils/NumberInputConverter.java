package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class NumberInputConverter {
    private static final String REGEX_NUMBER = "^[0-9]*$";
    private static final String SEPARATOR = ",";
    private static final NumberInputConverter INSTANCE = new NumberInputConverter();

    private NumberInputConverter() {

    }

    public static NumberInputConverter getInstance() {
        return INSTANCE;
    }

    private void validate(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("has empty input");
        }
        if (!input.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(input + " is not a valid number");
        }
    }

    public int toInt(String input) {
        validate(input);
        return Integer.parseInt(input);
    }

    public List<Integer> toList(String input) {
        return Arrays.stream(input.split(SEPARATOR, -1))
                .peek(this::validate)
                .map(Integer::parseInt)
                .toList();
    }
}
