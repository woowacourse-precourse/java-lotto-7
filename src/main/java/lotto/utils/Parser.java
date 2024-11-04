package lotto.utils;

import java.util.List;
import java.util.stream.Stream;

public class Parser {

    public static long stringToLong(String number) {
        try {
            return Long.parseLong(number.trim());
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessages.NUMBER_PARSE_ERROR);
        }
    }

    public static int stringToInt(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessages.NUMBER_PARSE_ERROR);
        }
    }

    public static List<Integer> splitNumbers(String rawWinNumbers) {
        try {
            return Stream.of(rawWinNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessages.SPLIT_NUMBER_ERROR);
        }
    }
}
