package util;

import java.util.List;
import java.util.stream.Collectors;

public class LottoFormatter {
    public static String formatLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
