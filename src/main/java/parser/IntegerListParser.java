package parser;

import java.util.Arrays;
import java.util.List;

public class IntegerListParser {

    private static final String CANT_PARSE_INT_ERROR_MESSAGE = "int 형으로 변환할 수 없습니다.";

    public IntegerListParser() {
    }

    public List<Integer> parse(String value, String delimiter) {
        try {
            String[] splitValue = value.split(delimiter);

            return Arrays.stream(splitValue)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(CANT_PARSE_INT_ERROR_MESSAGE);
        }
    }
}
