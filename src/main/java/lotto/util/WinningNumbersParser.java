package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.exception.ErrorMessages.LOTTO_NUMBER_NOT_INTEGER_ERROR;

public class WinningNumbersParser {
    public static final String WINNING_NUMBERS_DEFAULT_DELIMITER = ",";

    public static List<Integer> parse(String input){
        return Arrays.stream(input.split(WINNING_NUMBERS_DEFAULT_DELIMITER))
                .map(String::trim)
                .map(part -> {
                    try{
                        return Integer.parseInt(part);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(LOTTO_NUMBER_NOT_INTEGER_ERROR);
                    }
                })
                .toList();
    }
}
