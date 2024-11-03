package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class ParseUtil {
    private ParseUtil() {
    }

    public static List<String> splitByDelimiters(String s, String delimiters) {
        List<String> tokens = List.of(s.split(delimiters));
        return tokens;
    }

    public static List<Integer> parseToIntegerList(List<String> stringList) {
        return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String removeSpace(String input) {
        return input.replaceAll("\\s+", "");
    }
}
