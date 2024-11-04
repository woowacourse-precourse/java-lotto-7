package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Delimiter {
    public static List<String> separate(String raw, String regex) {
        return Arrays.stream(raw.split(regex))
                .map(String::trim)
                .toList();
    }
}
