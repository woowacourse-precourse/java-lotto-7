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

        validateLength(parsedNumbers);
        return parsedNumbers;
    }

    private static void validateLength(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }
}
