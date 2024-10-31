package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private static final String DELIMITER = ",";

    public final List<Integer> numbers;

    public WinningNumbers(String inputNumbers) {
        List<String> numbersInString = parse(inputNumbers);
    }

    private List<String> parse(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(DELIMITER))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }
}
