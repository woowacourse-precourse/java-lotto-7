package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static List<Integer> convertLottoNumber(String input) {
        return Arrays.stream(input.split(Constants.DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
