package lotto.model.service.parser;

import java.util.List;
import java.util.stream.Stream;

public class NumberParser {

    private static final String DELIMITER = ",";

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        return Stream.of(winningNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
