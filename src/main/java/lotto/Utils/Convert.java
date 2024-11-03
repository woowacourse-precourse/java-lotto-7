package lotto.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {
    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
