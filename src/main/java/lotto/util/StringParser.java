package lotto.util;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> splitByCommaAndTrim(String input) {
        String[] numbers = input.split(",");
        return Arrays.stream(numbers).map(String::trim).collect(toList());
    }

    public static int stringToInt(String number) {
        return Integer.parseInt(number.replaceAll(",", ""));
    }
}
