package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static final String DELIMITER = ",";

    private Converter(){
    }

    public static int convertToNumber(String input) {
        return Integer.parseInt(input.trim());
    }

    public static List<Integer> convertNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Converter::convertToNumber)
                .collect(Collectors.toList());
    }
}
