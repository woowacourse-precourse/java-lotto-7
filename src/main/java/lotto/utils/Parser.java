package lotto.utils;

import static java.util.stream.Collectors.toList;
import static lotto.exception.ErrorMessage.INVALID_WINNER_NUMBER_TYPE;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;

public class Parser {
    private static final String DELIMITER = ",";

    public static List<Integer> parse(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER)).map(String::trim).map(Integer::parseInt).collect(toList());
        } catch (NumberFormatException e) {
            throw new LottoException(INVALID_WINNER_NUMBER_TYPE);
        }
    }
}
