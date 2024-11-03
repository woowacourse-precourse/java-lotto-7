package lotto.Util.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputSplitter {
    private static final String DELIMITER = ",";

    public static List<Integer> splitByDelimiter(String winNumbers) {
        List<Integer> winningNumbers = Arrays.stream(winNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }
}
