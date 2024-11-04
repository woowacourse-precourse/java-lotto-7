package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ExceptionMessage;
import lotto.exception.InvalidLottoException;

public class ParserUtil {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidLottoException(ExceptionMessage.ERROR_NOT_INTEGER);
        }
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(ParserUtil::parseInt)
                .collect(Collectors.toList());
    }

}
