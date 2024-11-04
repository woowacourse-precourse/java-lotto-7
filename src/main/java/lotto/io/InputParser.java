package lotto.io;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorMessage;

public class InputParser {

    private static final String SPLIT_REG = ",";

    public long convertStringToLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_FORMAT_ERROR.format());
        }
    }

    public List<Integer> splitToInteger(String input) {
        String[] segments = input.split(SPLIT_REG);
        return Arrays.stream(segments).map(this::convertStringToInt).toList();
    }

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.format());
        }
    }
}
