package lotto.parser;

import lotto.constants.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMERIC.getMessage());
        }
    }

    public List<Integer> parseToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(this::parseToInt)
                .collect(Collectors.toList());
    }
}
