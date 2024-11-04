package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {
    private static final String DELIMITER = ",";

    public static List<Integer> ToNumberList(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
