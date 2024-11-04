package lotto.io.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {
    private static final String ERROR_NOT_NUMBER_FORMAT = "[ERROR] 숫자 형식이 아닙니다.";

    public InputConverter() {
    }

    public List<String> toList(String[] inputs) {
        return Arrays.asList(inputs);
    }

    public int toInteger(String input) {
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER_FORMAT);
        }
    }

    public List<Integer> toIntegerList(String[] input) {
        List<String> inputTokens = toList(input);
        return inputTokens.stream()
                .map(this::toInteger)
                .collect(Collectors.toList());
    }
}
