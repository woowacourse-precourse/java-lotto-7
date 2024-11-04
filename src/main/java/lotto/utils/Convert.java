package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {

    public static List<Integer> convertToIntegerList(String[] stringArray) {
        return Arrays.stream(stringArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
