package constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum OutputFormats {
    FIFTH_PLACE("3개 일치 (5,000원)"),
    FOURTH_PLACE("4개 일치 (50,000원)"),
    THIRD_PLACE("5개 일치 (1,500,000원)"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST_PLACE("6개 일치 (2,000,000,000원)");

    private final String format;

    OutputFormats(String format) {
        this.format = format;
    }

    public String getResultString(int count) {
        return format + " - " + count + "개";
    }

    public static List<String> getAllResults(List<Integer> counts) {
        List<Integer> reversedCounts = new ArrayList<>(counts);
        Collections.reverse(reversedCounts);

        return Arrays.stream(values())
                .map(format -> format.getResultString(reversedCounts.get(format.ordinal())))
                .collect(Collectors.toList());
    }
}