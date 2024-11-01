package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class utils {
    public static List<Integer> StringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
