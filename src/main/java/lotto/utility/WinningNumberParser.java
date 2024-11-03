package lotto.utility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberParser {
    private static final String DELIMITER = ",";

    public static List<Integer> parseWinningNumbers(String inputtedNumbers) {
        List<Integer> parsedNumbers = Stream.of(inputtedNumbers.split(DELIMITER))
                .map(String::trim)
                .map(rawNumber -> NumberParser.parseToInteger(rawNumber))
                .collect(Collectors.toList());

        return parsedNumbers;
    }
}
