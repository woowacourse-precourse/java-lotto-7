package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Converter {
    private Converter() {
    }

    public static List<Integer> toNumberList(String input) {
        return parseNumberStream(input).toList();
    }

    private static Stream<Integer> parseNumberStream(String input) {
        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt)
                .boxed();
    }
}
