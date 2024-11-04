package lotto.helper;

import java.util.Arrays;
import java.util.List;

public class ParseHelper {

    private static final String CANT_PARSE_INT_ERROR_MESSAGE = "int 형으로 변환할 수 없습니다.";

    public ParseHelper() {
    }

    public Integer parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(CANT_PARSE_INT_ERROR_MESSAGE);
        }
    }

    public List<Integer> parseIntegerList(String value, String delimiter) {
        String[] splitValue = value.split(delimiter);

        return Arrays.stream(splitValue)
                .map(String::trim)
                .map(this::parseInt)
                .toList();
    }
}
