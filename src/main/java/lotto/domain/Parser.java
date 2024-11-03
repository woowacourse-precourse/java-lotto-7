package lotto.domain;

import static lotto.domain.constant.ErrorMessage.NOT_INTEGER;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public int parseToInt(String input) {
        try {
            String inputWithoutSpace = input.replaceAll("\\s+", "");
            return Integer.parseInt(inputWithoutSpace);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    public List<Integer> parseToIntList(String input) {
        List<String> parsedString = parseComma(input);

        return parsedString.stream()
                .map(this::parseToInt)
                .toList();
    }

    private List<String> parseComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

}
