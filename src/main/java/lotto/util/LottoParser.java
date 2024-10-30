package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.error.LottoError;

public abstract class LottoParser {

    private static final String NUMBERS_DELIMITER = ",";

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER.getMessage());
        }
    }

    public static List<Integer> parseNumbers(String numbers){
        return Arrays.stream(numbers.split(NUMBERS_DELIMITER))
                .map(LottoParser::parseInt)
                .collect(Collectors.toList());
    }
}
