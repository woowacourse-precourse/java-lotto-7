package lotto.utility;

import java.util.Arrays;
import java.util.List;

public class FormatConverter {
    public static List<Integer> convertStringToInteger(String rawInput) {
        String[] input = rawInput.split(Delimiter.COMMA.getDelimiter());
        return Arrays.stream(input).map(Integer::parseInt).toList();
    }
}
