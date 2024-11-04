package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToLottoConverter {
    public static List<Integer> convert(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
