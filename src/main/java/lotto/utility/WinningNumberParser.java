package lotto.utility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberParser {

    public static List<Integer> parseWinningNumbers(String inputtedNumbers) {
        List<Integer> parsedNumbers = Stream.of(inputtedNumbers.split(","))
                .map(String::trim)
                .map(rawNumber -> {
                    return NumberParser.parseToInteger(rawNumber);
                })
                .collect(Collectors.toList());

        return parsedNumbers;
    }
}
