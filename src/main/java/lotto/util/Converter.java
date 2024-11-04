package lotto.util;

import java.util.Arrays;
import java.util.List;

public final class Converter {

    private static final String COMMA = ",";

    private Converter() {}

    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> splitComma(String input) {
        return Arrays.stream(input.split(COMMA))
            .map(Integer::parseInt)
            .toList();
    }
}
