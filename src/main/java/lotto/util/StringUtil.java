package lotto.util;

import java.util.List;

public class StringUtil {

    public static List<String> converList(String value, String delimiter) {
        return toList(split(value, delimiter));
    }

    private static String[] split(String value, String delimiter) {
        return value.split(delimiter);
    }

    private static List<String> toList(String[] value) {
        return List.of(value);
    }
}
