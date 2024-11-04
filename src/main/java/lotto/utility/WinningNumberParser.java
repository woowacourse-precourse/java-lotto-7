package lotto.utility;

import lotto.constants.Constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberParser {

    public static List<Integer> parseWinningNumbers(String inputtedNumbers) {
        List<Integer> parsedNumbers = Stream.of(inputtedNumbers.split(Constants.WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .map(rawNumber -> NumberParser.parseToInteger(rawNumber))
                .collect(Collectors.toList());

        return parsedNumbers;
    }
}
