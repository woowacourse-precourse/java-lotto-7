package lotto.application.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INVALID_NUMBER_FORMAT = ERROR_PREFIX + "숫자로 변환할 수 없는 값입니다.";

    public static final String NUMBER_DELIMITER = ",";

    private StringConverter() {
    }

    public static int toInt(String value) {
        StringValidator.validateNotBlank(value);

        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }

    public static String trim(String text) {
        StringValidator.validateNotBlank(text);
        return text.trim();
    }

    public static String[] split(String text) {
        StringValidator.validateNotBlank(text);
        return text.split(NUMBER_DELIMITER);
    }

    public static List<Integer> toInts(String[] values) {
        return Arrays.stream(values)
                .map(StringConverter::toInt)
                .collect(Collectors.toList());
    }

}
