package utils;

import java.util.Arrays;
import java.util.List;

public class TypeConverter {
    private static final String DELIMITER = ",";

    public static int ToNumber(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> ToList(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
